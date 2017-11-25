package cz.muni.fi.dto;

import cz.muni.fi.enums.ComponentType;
import lombok.Getter;
import lombok.Setter;

public class ComponentCreateDTO {

    @Getter @Setter private String name;
    @Getter @Setter private ComponentType type;
    @Getter @Setter private Boolean isAvailable;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof ComponentCreateDTO)) return false;

        ComponentCreateDTO that = (ComponentCreateDTO) o;

        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getType() == that.getType();
    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
