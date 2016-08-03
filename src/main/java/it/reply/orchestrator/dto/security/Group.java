package it.reply.orchestrator.dto.security;

import com.google.gson.JsonObject;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;

public class Group implements Serializable {

  private static final long serialVersionUID = -7021998143096821266L;

  private static final String GROUP_ID_KEY = "id";
  private static final String GROUP_NAME_KEY = "name";

  private String id;
  private String name;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Serialize this Group object to JSON.
   * 
   * @return the {@link JsonObject} serialization of the group.
   */
  public JsonObject toJson() {
    JsonObject obj = new JsonObject();
    obj.addProperty(GROUP_ID_KEY, this.getId());
    obj.addProperty(GROUP_NAME_KEY, this.getName());
    return obj;
  }

  /**
   * Deserialize a Group object from JSON.
   * 
   * @param obj
   *          the JsonObject containing the Group serialized representation.
   * @return the {@link Group} deserialized.
   */
  public static Group fromJson(JsonObject obj) {
    Group result = new Group();
    result.setId(obj.has(GROUP_ID_KEY) && obj.get(GROUP_ID_KEY).isJsonPrimitive()
        ? obj.get(GROUP_ID_KEY).getAsString() : null);
    result.setName(obj.has(GROUP_NAME_KEY) && obj.get(GROUP_NAME_KEY).isJsonPrimitive()
        ? obj.get(GROUP_NAME_KEY).getAsString() : null);
    return result;
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder().appendSuper(super.hashCode()).append(this.getId())
        .append(this.getName()).build();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null || !(obj instanceof Group)) {
      return false;
    }
    Group other = (Group) obj;
    return new EqualsBuilder().appendSuper(super.equals(other)).append(this.getId(), other.getId())
        .append(this.getName(), other.getName()).build();
  }
}
