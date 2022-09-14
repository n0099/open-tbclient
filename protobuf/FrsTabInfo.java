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
public final class FrsTabInfo extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Integer DEFAULT_ISDEFAULT;
    public static final Integer DEFAULT_ISGENERALTAB;
    public static final Integer DEFAULT_NEEDPAGE;
    public static final String DEFAULT_TABCODE = "";
    public static final String DEFAULT_TABGID = "";
    public static final Integer DEFAULT_TABID;
    public static final String DEFAULT_TABNAME = "";
    public static final String DEFAULT_TABTITLE = "";
    public static final Integer DEFAULT_TABTYPE;
    public static final String DEFAULT_TABURL = "";
    public static final Integer DEFAULT_TABVERSION;
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(tag = 10, type = Message.Datatype.INT32)
    public final Integer isDefault;
    @ProtoField(tag = 7, type = Message.Datatype.INT32)
    public final Integer isGeneralTab;
    @ProtoField(tag = 11, type = Message.Datatype.INT32)
    public final Integer needPage;
    @ProtoField(tag = 8, type = Message.Datatype.STRING)
    public final String tabCode;
    @ProtoField(tag = 5, type = Message.Datatype.STRING)
    public final String tabGid;
    @ProtoField(tag = 1, type = Message.Datatype.INT32)
    public final Integer tabId;
    @ProtoField(tag = 3, type = Message.Datatype.STRING)
    public final String tabName;
    @ProtoField(tag = 6, type = Message.Datatype.STRING)
    public final String tabTitle;
    @ProtoField(tag = 2, type = Message.Datatype.INT32)
    public final Integer tabType;
    @ProtoField(tag = 4, type = Message.Datatype.STRING)
    public final String tabUrl;
    @ProtoField(tag = 9, type = Message.Datatype.UINT32)
    public final Integer tabVersion;

    /* loaded from: classes9.dex */
    public static final class Builder extends Message.Builder<FrsTabInfo> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Integer isDefault;
        public Integer isGeneralTab;
        public Integer needPage;
        public String tabCode;
        public String tabGid;
        public Integer tabId;
        public String tabName;
        public String tabTitle;
        public Integer tabType;
        public String tabUrl;
        public Integer tabVersion;

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
        public Builder(FrsTabInfo frsTabInfo) {
            super(frsTabInfo);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {frsTabInfo};
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
            if (frsTabInfo == null) {
                return;
            }
            this.tabId = frsTabInfo.tabId;
            this.tabType = frsTabInfo.tabType;
            this.tabName = frsTabInfo.tabName;
            this.tabUrl = frsTabInfo.tabUrl;
            this.tabGid = frsTabInfo.tabGid;
            this.tabTitle = frsTabInfo.tabTitle;
            this.isGeneralTab = frsTabInfo.isGeneralTab;
            this.tabCode = frsTabInfo.tabCode;
            this.tabVersion = frsTabInfo.tabVersion;
            this.isDefault = frsTabInfo.isDefault;
            this.needPage = frsTabInfo.needPage;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.squareup.wire.Message.Builder
        public FrsTabInfo build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) ? new FrsTabInfo(this, z, null) : (FrsTabInfo) invokeZ.objValue;
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
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(961170087, "Lprotobuf/FrsTabInfo;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(961170087, "Lprotobuf/FrsTabInfo;");
                return;
            }
        }
        DEFAULT_TABID = 0;
        DEFAULT_TABTYPE = 0;
        DEFAULT_ISGENERALTAB = 0;
        DEFAULT_TABVERSION = 0;
        DEFAULT_ISDEFAULT = 0;
        DEFAULT_NEEDPAGE = 0;
    }

    public /* synthetic */ FrsTabInfo(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrsTabInfo(Builder builder, boolean z) {
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
            Integer num = builder.tabId;
            if (num == null) {
                this.tabId = DEFAULT_TABID;
            } else {
                this.tabId = num;
            }
            Integer num2 = builder.tabType;
            if (num2 == null) {
                this.tabType = DEFAULT_TABTYPE;
            } else {
                this.tabType = num2;
            }
            String str = builder.tabName;
            if (str == null) {
                this.tabName = "";
            } else {
                this.tabName = str;
            }
            String str2 = builder.tabUrl;
            if (str2 == null) {
                this.tabUrl = "";
            } else {
                this.tabUrl = str2;
            }
            String str3 = builder.tabGid;
            if (str3 == null) {
                this.tabGid = "";
            } else {
                this.tabGid = str3;
            }
            String str4 = builder.tabTitle;
            if (str4 == null) {
                this.tabTitle = "";
            } else {
                this.tabTitle = str4;
            }
            Integer num3 = builder.isGeneralTab;
            if (num3 == null) {
                this.isGeneralTab = DEFAULT_ISGENERALTAB;
            } else {
                this.isGeneralTab = num3;
            }
            String str5 = builder.tabCode;
            if (str5 == null) {
                this.tabCode = "";
            } else {
                this.tabCode = str5;
            }
            Integer num4 = builder.tabVersion;
            if (num4 == null) {
                this.tabVersion = DEFAULT_TABVERSION;
            } else {
                this.tabVersion = num4;
            }
            Integer num5 = builder.isDefault;
            if (num5 == null) {
                this.isDefault = DEFAULT_ISDEFAULT;
            } else {
                this.isDefault = num5;
            }
            Integer num6 = builder.needPage;
            if (num6 == null) {
                this.needPage = DEFAULT_NEEDPAGE;
                return;
            } else {
                this.needPage = num6;
                return;
            }
        }
        this.tabId = builder.tabId;
        this.tabType = builder.tabType;
        this.tabName = builder.tabName;
        this.tabUrl = builder.tabUrl;
        this.tabGid = builder.tabGid;
        this.tabTitle = builder.tabTitle;
        this.isGeneralTab = builder.isGeneralTab;
        this.tabCode = builder.tabCode;
        this.tabVersion = builder.tabVersion;
        this.isDefault = builder.isDefault;
        this.needPage = builder.needPage;
    }
}
