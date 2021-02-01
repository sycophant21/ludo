public class RelationshipManager {

    public static Relationship getRelationship(char token1, char token2) {
        if (token1 == 'R') {
            if (token2 == 'G') {
                return Relationship.OPPOSITE;
            }
            else if (token2 == 'B') {
                return Relationship.RIGHT;
            }
            else if (token2 == 'Y') {
                return Relationship.LEFT;
            }
            else {
                return null;
            }
        }
        else if (token1 == 'G') {
            if (token2 == 'R') {
                return Relationship.OPPOSITE;
            }
            else if (token2 == 'Y') {
                return Relationship.RIGHT;
            }
            else if (token2 == 'B') {
                return Relationship.LEFT;
            }
            else {
                return null;
            }
        }
        else if (token1 == 'B') {
            if (token2 == 'Y') {
                return Relationship.OPPOSITE;
            }
            else if (token2 == 'G') {
                return Relationship.RIGHT;
            }
            else if (token2 == 'R') {
                return Relationship.LEFT;
            }
            else {
                return null;
            }
        }
        else if (token1 == 'Y') {
            if (token2 == 'B') {
                return Relationship.OPPOSITE;
            }
            else if (token2 == 'R') {
                return Relationship.RIGHT;
            }
            else if (token2 == 'G') {
                return Relationship.LEFT;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }

    }
}
