package kotlin.reflect.jvm.internal.impl.incremental.components;

import com.baidu.tbadk.core.data.SmallTailInfo;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* loaded from: classes9.dex */
public final class Position implements Serializable {
    public static final Companion Companion = new Companion(null);
    public static final Position NO_POSITION = new Position(-1, -1);
    public final int column;
    public final int line;

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof Position) {
                Position position = (Position) obj;
                return this.line == position.line && this.column == position.column;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        return "Position(line=" + this.line + ", column=" + this.column + SmallTailInfo.EMOTION_SUFFIX;
    }

    /* loaded from: classes9.dex */
    public static final class Companion {
        public Companion() {
        }

        public final Position getNO_POSITION() {
            return Position.NO_POSITION;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Position(int i, int i2) {
        this.line = i;
        this.column = i2;
    }
}
