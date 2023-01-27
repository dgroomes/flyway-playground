package dgroomes;

import java.util.List;

public record Observation(
        String description,
        List<String> notes) {
}
