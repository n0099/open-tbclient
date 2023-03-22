package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import com.baidu.android.common.others.IStringUtil;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.DeprecationLevel;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
/* loaded from: classes9.dex */
public final class VersionRequirement {
    public static final Companion Companion = new Companion(null);
    public final Integer errorCode;
    public final ProtoBuf.VersionRequirement.VersionKind kind;
    public final DeprecationLevel level;
    public final String message;
    public final Version version;

    /* loaded from: classes9.dex */
    public static final class Version {
        public static final Companion Companion = new Companion(null);
        @JvmField
        public static final Version INFINITY = new Version(256, 256, 256);
        public final int major;
        public final int minor;
        public final int patch;

        public boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof Version) {
                    Version version = (Version) obj;
                    return this.major == version.major && this.minor == version.minor && this.patch == version.patch;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.major * 31) + this.minor) * 31) + this.patch;
        }

        /* loaded from: classes9.dex */
        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Version decode(Integer num, Integer num2) {
                if (num2 != null) {
                    return new Version(num2.intValue() & 255, (num2.intValue() >> 8) & 255, (num2.intValue() >> 16) & 255);
                }
                if (num != null) {
                    return new Version(num.intValue() & 7, (num.intValue() >> 3) & 15, (num.intValue() >> 7) & 127);
                }
                return Version.INFINITY;
            }
        }

        public String toString() {
            return asString();
        }

        public Version(int i, int i2, int i3) {
            this.major = i;
            this.minor = i2;
            this.patch = i3;
        }

        public /* synthetic */ Version(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(i, i2, (i4 & 4) != 0 ? 0 : i3);
        }

        public final String asString() {
            StringBuilder sb;
            int i;
            if (this.patch == 0) {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                i = this.minor;
            } else {
                sb = new StringBuilder();
                sb.append(this.major);
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                sb.append(this.minor);
                sb.append(IStringUtil.EXTENSION_SEPARATOR);
                i = this.patch;
            }
            sb.append(i);
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    public static final class Companion {

        /* loaded from: classes9.dex */
        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProtoBuf.VersionRequirement.Level.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[ProtoBuf.VersionRequirement.Level.WARNING.ordinal()] = 1;
                $EnumSwitchMapping$0[ProtoBuf.VersionRequirement.Level.ERROR.ordinal()] = 2;
                $EnumSwitchMapping$0[ProtoBuf.VersionRequirement.Level.HIDDEN.ordinal()] = 3;
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final List<VersionRequirement> create(MessageLite messageLite, NameResolver nameResolver, VersionRequirementTable versionRequirementTable) {
            List<Integer> ids;
            if (messageLite instanceof ProtoBuf.Class) {
                ids = ((ProtoBuf.Class) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Constructor) {
                ids = ((ProtoBuf.Constructor) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Function) {
                ids = ((ProtoBuf.Function) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.Property) {
                ids = ((ProtoBuf.Property) messageLite).getVersionRequirementList();
            } else if (messageLite instanceof ProtoBuf.TypeAlias) {
                ids = ((ProtoBuf.TypeAlias) messageLite).getVersionRequirementList();
            } else {
                throw new IllegalStateException("Unexpected declaration: " + messageLite.getClass());
            }
            Intrinsics.checkExpressionValueIsNotNull(ids, "ids");
            ArrayList arrayList = new ArrayList();
            for (Integer id : ids) {
                Companion companion = VersionRequirement.Companion;
                Intrinsics.checkExpressionValueIsNotNull(id, "id");
                VersionRequirement create = companion.create(id.intValue(), nameResolver, versionRequirementTable);
                if (create != null) {
                    arrayList.add(create);
                }
            }
            return arrayList;
        }

        public final VersionRequirement create(int i, NameResolver nameResolver, VersionRequirementTable versionRequirementTable) {
            Integer num;
            Integer num2;
            DeprecationLevel deprecationLevel;
            Integer num3;
            ProtoBuf.VersionRequirement versionRequirement = versionRequirementTable.get(i);
            String str = null;
            if (versionRequirement == null) {
                return null;
            }
            Version.Companion companion = Version.Companion;
            if (versionRequirement.hasVersion()) {
                num = Integer.valueOf(versionRequirement.getVersion());
            } else {
                num = null;
            }
            if (versionRequirement.hasVersionFull()) {
                num2 = Integer.valueOf(versionRequirement.getVersionFull());
            } else {
                num2 = null;
            }
            Version decode = companion.decode(num, num2);
            ProtoBuf.VersionRequirement.Level level = versionRequirement.getLevel();
            if (level == null) {
                Intrinsics.throwNpe();
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[level.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        deprecationLevel = DeprecationLevel.HIDDEN;
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    deprecationLevel = DeprecationLevel.ERROR;
                }
            } else {
                deprecationLevel = DeprecationLevel.WARNING;
            }
            DeprecationLevel deprecationLevel2 = deprecationLevel;
            if (versionRequirement.hasErrorCode()) {
                num3 = Integer.valueOf(versionRequirement.getErrorCode());
            } else {
                num3 = null;
            }
            if (versionRequirement.hasMessage()) {
                str = nameResolver.getString(versionRequirement.getMessage());
            }
            ProtoBuf.VersionRequirement.VersionKind versionKind = versionRequirement.getVersionKind();
            Intrinsics.checkExpressionValueIsNotNull(versionKind, "info.versionKind");
            return new VersionRequirement(decode, versionKind, deprecationLevel2, num3, str);
        }
    }

    public VersionRequirement(Version version, ProtoBuf.VersionRequirement.VersionKind versionKind, DeprecationLevel deprecationLevel, Integer num, String str) {
        this.version = version;
        this.kind = versionKind;
        this.level = deprecationLevel;
        this.errorCode = num;
        this.message = str;
    }

    public final ProtoBuf.VersionRequirement.VersionKind getKind() {
        return this.kind;
    }

    public final Version getVersion() {
        return this.version;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("since ");
        sb.append(this.version);
        sb.append(WebvttCueParser.CHAR_SPACE);
        sb.append(this.level);
        String str2 = "";
        if (this.errorCode == null) {
            str = "";
        } else {
            str = " error " + this.errorCode;
        }
        sb.append(str);
        if (this.message != null) {
            str2 = ": " + this.message;
        }
        sb.append(str2);
        return sb.toString();
    }
}
