package top.kikt.ijkplayer.entity;

import java.util.Map;
/* loaded from: classes6.dex */
public class IjkOption {
    private boolean isInit;
    public String key;
    public Type type;
    public Object value;

    /* loaded from: classes6.dex */
    public enum Type {
        Format,
        Codec,
        Sws,
        Player,
        Other
    }

    public IjkOption(Map map) {
        if (map != null) {
            Object obj = map.get("category");
            if (obj instanceof Integer) {
                this.type = convertIntToType(((Integer) obj).intValue());
            }
            Object obj2 = map.get("key");
            if (obj2 instanceof String) {
                this.key = (String) obj2;
            }
            Object obj3 = map.get("value");
            if (obj3 != null) {
                this.value = obj3;
            }
            this.isInit = true;
        }
    }

    private final Type convertIntToType(int i) {
        switch (i) {
            case 0:
                return Type.Format;
            case 1:
                return Type.Codec;
            case 2:
                return Type.Sws;
            case 3:
                return Type.Player;
            default:
                return Type.Other;
        }
    }

    public static int convertTocategory(Type type) {
        switch (type) {
            case Format:
                return 1;
            case Codec:
                return 4;
            case Sws:
                return 3;
            case Player:
                return 2;
            default:
                return -1;
        }
    }
}
