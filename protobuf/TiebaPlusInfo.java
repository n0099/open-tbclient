package protobuf;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
/* loaded from: classes9.dex */
public final class TiebaPlusInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_APPCOMPANY = "";
    public static final String DEFAULT_APPICON = "";
    public static final String DEFAULT_APPID = "";
    public static final String DEFAULT_APPPACKAGE = "";
    public static final String DEFAULT_APPPOWER = "";
    public static final String DEFAULT_APPPRIVACY = "";
    public static final String DEFAULT_APPVERSION = "";
    public static final String DEFAULT_BUTTONDESC = "";
    public static final String DEFAULT_DESC = "";
    public static final String DEFAULT_DOWNLOADURL = "";
    public static final String DEFAULT_FORUMNAME = "";
    public static final String DEFAULT_H5JUMPNUMBER = "";
    public static final String DEFAULT_H5JUMPPARAM = "";
    public static final Integer DEFAULT_H5JUMPTYPE;
    public static final Integer DEFAULT_ISAPPOINT;
    public static final String DEFAULT_ITEMID = "";
    public static final Integer DEFAULT_JUMPSETTING;
    public static final Integer DEFAULT_JUMPTYPE;
    public static final String DEFAULT_JUMPURL = "";
    public static final Integer DEFAULT_TARGETTYPE;
    public static final String DEFAULT_TITLE = "";
    public static final String DEFAULT_WXTHUMBNAIL = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 11, type = Message.Datatype.STRING)
    public final String appCompany;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String appIcon;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String appId;
    @ProtoField(tag = 7, type = Message.Datatype.STRING)
    public final String appPackage;
    @ProtoField(tag = 10, type = Message.Datatype.STRING)
    public final String appPower;
    @ProtoField(tag = 9, type = Message.Datatype.STRING)
    public final String appPrivacy;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String appVersion;
    @ProtoField(tag = 23, type = Message.Datatype.STRING)
    public final String buttonDesc;
    @ProtoField(tag = 2, type = Message.Datatype.STRING)
    public final String desc;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String downloadUrl;
    @ProtoField(tag = 20, type = Message.Datatype.STRING)
    public final String forumName;
    @ProtoField(tag = 14, type = Message.Datatype.STRING)
    public final String h5JumpNumber;
    @ProtoField(tag = 15, type = Message.Datatype.STRING)
    public final String h5JumpParam;
    @ProtoField(tag = 13, type = Message.Datatype.INT32)
    public final Integer h5JumpType;
    @ProtoField(tag = 18, type = Message.Datatype.INT32)
    public final Integer isAppoint;
    @ProtoField(tag = 17, type = Message.Datatype.STRING)
    public final String itemId;
    @ProtoField(tag = 21, type = Message.Datatype.INT32)
    public final Integer jumpSetting;
    @ProtoField(tag = 16, type = Message.Datatype.INT32)
    public final Integer jumpType;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String jumpUrl;
    @ProtoField(tag = 19)
    public final PluginUser pluginUser;
    @ProtoField(tag = 12, type = Message.Datatype.INT32)
    public final Integer targetType;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String title;
    @ProtoField(tag = 22, type = Message.Datatype.STRING)
    public final String wxThumbnail;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<TiebaPlusInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String appCompany;
        public String appIcon;
        public String appId;
        public String appPackage;
        public String appPower;
        public String appPrivacy;
        public String appVersion;
        public String buttonDesc;
        public String desc;
        public String downloadUrl;
        public String forumName;
        public String h5JumpNumber;
        public String h5JumpParam;
        public Integer h5JumpType;
        public Integer isAppoint;
        public String itemId;
        public Integer jumpSetting;
        public Integer jumpType;
        public String jumpUrl;
        public PluginUser pluginUser;
        public Integer targetType;
        public String title;
        public String wxThumbnail;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(TiebaPlusInfo tiebaPlusInfo) {
            super(tiebaPlusInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {tiebaPlusInfo};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (tiebaPlusInfo == null) {
                return;
            }
            this.title = tiebaPlusInfo.title;
            this.desc = tiebaPlusInfo.desc;
            this.jumpUrl = tiebaPlusInfo.jumpUrl;
            this.downloadUrl = tiebaPlusInfo.downloadUrl;
            this.appId = tiebaPlusInfo.appId;
            this.appIcon = tiebaPlusInfo.appIcon;
            this.appPackage = tiebaPlusInfo.appPackage;
            this.appVersion = tiebaPlusInfo.appVersion;
            this.appPrivacy = tiebaPlusInfo.appPrivacy;
            this.appPower = tiebaPlusInfo.appPower;
            this.appCompany = tiebaPlusInfo.appCompany;
            this.targetType = tiebaPlusInfo.targetType;
            this.h5JumpType = tiebaPlusInfo.h5JumpType;
            this.h5JumpNumber = tiebaPlusInfo.h5JumpNumber;
            this.h5JumpParam = tiebaPlusInfo.h5JumpParam;
            this.jumpType = tiebaPlusInfo.jumpType;
            this.itemId = tiebaPlusInfo.itemId;
            this.isAppoint = tiebaPlusInfo.isAppoint;
            this.pluginUser = tiebaPlusInfo.pluginUser;
            this.forumName = tiebaPlusInfo.forumName;
            this.jumpSetting = tiebaPlusInfo.jumpSetting;
            this.wxThumbnail = tiebaPlusInfo.wxThumbnail;
            this.buttonDesc = tiebaPlusInfo.buttonDesc;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public TiebaPlusInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new TiebaPlusInfo(this, z, null) : (TiebaPlusInfo) invokeZ.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-366274276, "Lprotobuf/TiebaPlusInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-366274276, "Lprotobuf/TiebaPlusInfo;");
                return;
            }
        }
        DEFAULT_TARGETTYPE = 0;
        DEFAULT_H5JUMPTYPE = 0;
        DEFAULT_JUMPTYPE = 0;
        DEFAULT_ISAPPOINT = 0;
        DEFAULT_JUMPSETTING = 0;
    }

    public /* synthetic */ TiebaPlusInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TiebaPlusInfo(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            String str = builder.title;
            if (str == null) {
                this.title = "";
            } else {
                this.title = str;
            }
            String str2 = builder.desc;
            if (str2 == null) {
                this.desc = "";
            } else {
                this.desc = str2;
            }
            String str3 = builder.jumpUrl;
            if (str3 == null) {
                this.jumpUrl = "";
            } else {
                this.jumpUrl = str3;
            }
            String str4 = builder.downloadUrl;
            if (str4 == null) {
                this.downloadUrl = "";
            } else {
                this.downloadUrl = str4;
            }
            String str5 = builder.appId;
            if (str5 == null) {
                this.appId = "";
            } else {
                this.appId = str5;
            }
            String str6 = builder.appIcon;
            if (str6 == null) {
                this.appIcon = "";
            } else {
                this.appIcon = str6;
            }
            String str7 = builder.appPackage;
            if (str7 == null) {
                this.appPackage = "";
            } else {
                this.appPackage = str7;
            }
            String str8 = builder.appVersion;
            if (str8 == null) {
                this.appVersion = "";
            } else {
                this.appVersion = str8;
            }
            String str9 = builder.appPrivacy;
            if (str9 == null) {
                this.appPrivacy = "";
            } else {
                this.appPrivacy = str9;
            }
            String str10 = builder.appPower;
            if (str10 == null) {
                this.appPower = "";
            } else {
                this.appPower = str10;
            }
            String str11 = builder.appCompany;
            if (str11 == null) {
                this.appCompany = "";
            } else {
                this.appCompany = str11;
            }
            Integer num = builder.targetType;
            if (num == null) {
                this.targetType = DEFAULT_TARGETTYPE;
            } else {
                this.targetType = num;
            }
            Integer num2 = builder.h5JumpType;
            if (num2 == null) {
                this.h5JumpType = DEFAULT_H5JUMPTYPE;
            } else {
                this.h5JumpType = num2;
            }
            String str12 = builder.h5JumpNumber;
            if (str12 == null) {
                this.h5JumpNumber = "";
            } else {
                this.h5JumpNumber = str12;
            }
            String str13 = builder.h5JumpParam;
            if (str13 == null) {
                this.h5JumpParam = "";
            } else {
                this.h5JumpParam = str13;
            }
            Integer num3 = builder.jumpType;
            if (num3 == null) {
                this.jumpType = DEFAULT_JUMPTYPE;
            } else {
                this.jumpType = num3;
            }
            String str14 = builder.itemId;
            if (str14 == null) {
                this.itemId = "";
            } else {
                this.itemId = str14;
            }
            Integer num4 = builder.isAppoint;
            if (num4 == null) {
                this.isAppoint = DEFAULT_ISAPPOINT;
            } else {
                this.isAppoint = num4;
            }
            this.pluginUser = builder.pluginUser;
            String str15 = builder.forumName;
            if (str15 == null) {
                this.forumName = "";
            } else {
                this.forumName = str15;
            }
            Integer num5 = builder.jumpSetting;
            if (num5 == null) {
                this.jumpSetting = DEFAULT_JUMPSETTING;
            } else {
                this.jumpSetting = num5;
            }
            String str16 = builder.wxThumbnail;
            if (str16 == null) {
                this.wxThumbnail = "";
            } else {
                this.wxThumbnail = str16;
            }
            String str17 = builder.buttonDesc;
            if (str17 == null) {
                this.buttonDesc = "";
                return;
            } else {
                this.buttonDesc = str17;
                return;
            }
        }
        this.title = builder.title;
        this.desc = builder.desc;
        this.jumpUrl = builder.jumpUrl;
        this.downloadUrl = builder.downloadUrl;
        this.appId = builder.appId;
        this.appIcon = builder.appIcon;
        this.appPackage = builder.appPackage;
        this.appVersion = builder.appVersion;
        this.appPrivacy = builder.appPrivacy;
        this.appPower = builder.appPower;
        this.appCompany = builder.appCompany;
        this.targetType = builder.targetType;
        this.h5JumpType = builder.h5JumpType;
        this.h5JumpNumber = builder.h5JumpNumber;
        this.h5JumpParam = builder.h5JumpParam;
        this.jumpType = builder.jumpType;
        this.itemId = builder.itemId;
        this.isAppoint = builder.isAppoint;
        this.pluginUser = builder.pluginUser;
        this.forumName = builder.forumName;
        this.jumpSetting = builder.jumpSetting;
        this.wxThumbnail = builder.wxThumbnail;
        this.buttonDesc = builder.buttonDesc;
    }
}
