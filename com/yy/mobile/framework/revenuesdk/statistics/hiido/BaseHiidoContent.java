package com.yy.mobile.framework.revenuesdk.statistics.hiido;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payservice.utils.MD5Utils;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\r\u0018\u0000 \u00112\u00020\u0001:\u0002\u0012\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u001b\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0016\u0010\f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\nR\u0016\u0010\r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/AbstractHiidoContent;", "", "getAct", "()Ljava/lang/String;", "getContent", "", "getMapContent", "()Ljava/util/Map;", "mAct", "Ljava/lang/String;", "mAppId", "mHostId", "mUid", "mUseChannel", "<init>", "()V", "Companion", "BaseHiidoContentBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes4.dex */
public final class BaseHiidoContent extends AbstractHiidoContent {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACT = "act";
    public static final String APPID = "appid";
    public static final String APPKEY = "appkey";
    public static final String BUNDLEID = "bundleid";
    public static final String CLIENTVER = "clientver";
    public static final Companion Companion;
    public static final String HIIDOYYSYSTEM = "HiidoYYSystem";
    public static final String HOSTID = "hostid";
    public static final String KEY = "key";
    public static final String MBOS = "mbos";
    public static final String SDKVER = "paysdkversion";
    public static final String SJM = "sjm";
    public static final String SYS = "sys";
    public static final String TIME = "time";
    public static final String UID = "uid";
    public static final String USECHANNEL = "usechannel";
    public transient /* synthetic */ FieldHolder $fh;
    public String mAct;
    public String mAppId;
    public String mHostId;
    public String mUid;
    public String mUseChannel;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u0000B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0007J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0007J\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0007R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent$BaseHiidoContentBuilder;", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "build", "()Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "", "act", "setAct", "(Ljava/lang/String;)Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent$BaseHiidoContentBuilder;", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "setAppId", "hostId", "setHostId", "uid", "setUid", "useChannel", "setUseChannel", "baseHiidoContent", "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class BaseHiidoContentBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BaseHiidoContent baseHiidoContent;

        public BaseHiidoContentBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.baseHiidoContent = new BaseHiidoContent(null);
        }

        public final BaseHiidoContent build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.baseHiidoContent : (BaseHiidoContent) invokeV.objValue;
        }

        public final BaseHiidoContentBuilder setAct(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
                this.baseHiidoContent.mAct = str;
                return this;
            }
            return (BaseHiidoContentBuilder) invokeL.objValue;
        }

        public final BaseHiidoContentBuilder setAppId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
                this.baseHiidoContent.mAppId = str;
                return this;
            }
            return (BaseHiidoContentBuilder) invokeL.objValue;
        }

        public final BaseHiidoContentBuilder setHostId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                this.baseHiidoContent.mHostId = str;
                return this;
            }
            return (BaseHiidoContentBuilder) invokeL.objValue;
        }

        public final BaseHiidoContentBuilder setUid(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
                this.baseHiidoContent.mUid = str;
                return this;
            }
            return (BaseHiidoContentBuilder) invokeL.objValue;
        }

        public final BaseHiidoContentBuilder setUseChannel(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
                this.baseHiidoContent.mUseChannel = str;
                return this;
            }
            return (BaseHiidoContentBuilder) invokeL.objValue;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0086\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0002\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0016\u0010\u0005\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0016\u0010\u0006\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0016\u0010\u0007\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0016\u0010\b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0003R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0016\u0010\n\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0003R\u0016\u0010\u000b\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0016\u0010\f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0016\u0010\r\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0016\u0010\u000e\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0016\u0010\u000f\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003R\u0016\u0010\u0010\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0003R\u0016\u0010\u0011\u001a\u00020\u00018\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0003¨\u0006\u0014"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent$Companion;", "", "ACT", "Ljava/lang/String;", "APPID", "APPKEY", "BUNDLEID", "CLIENTVER", "HIIDOYYSYSTEM", "HOSTID", "KEY", "MBOS", "SDKVER", "SJM", "SYS", "TIME", "UID", "USECHANNEL", "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Companion() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1132658684, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1132658684, "Lcom/yy/mobile/framework/revenuesdk/statistics/hiido/BaseHiidoContent;");
                return;
            }
        }
        Companion = new Companion(null);
    }

    public BaseHiidoContent() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mAct = "-1";
        this.mAppId = "";
        this.mUseChannel = "";
        this.mHostId = "";
        this.mUid = "";
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public String getAct() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mAct : (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("act");
            sb.append("=");
            sb.append(URLEncoder.encode(this.mAct, "UTF-8"));
            sb.append("&");
            String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
            sb.append("time");
            sb.append("=");
            sb.append(URLEncoder.encode(valueOf, "UTF-8"));
            sb.append("&");
            sb.append("key");
            sb.append("=");
            sb.append(URLEncoder.encode(MD5Utils.getMD5String(this.mAct + valueOf + "HiidoYYSystem"), "UTF-8"));
            sb.append("&");
            sb.append("appid");
            sb.append("=");
            sb.append(this.mAppId);
            sb.append("&");
            sb.append(USECHANNEL);
            sb.append("=");
            sb.append(this.mUseChannel);
            sb.append("&");
            sb.append(HOSTID);
            sb.append("=");
            sb.append(this.mHostId);
            sb.append("&");
            sb.append("uid");
            sb.append("=");
            sb.append(this.mUid);
            sb.append("&");
            sb.append("appkey");
            sb.append("=");
            sb.append(URLEncoder.encode(HiidoConstantContent.mAppKey, "UTF-8"));
            sb.append("&");
            sb.append(SDKVER);
            sb.append("=");
            sb.append(URLEncoder.encode(HiidoConstantContent.mSdkVer, "UTF-8"));
            sb.append("&");
            sb.append(BUNDLEID);
            sb.append("=");
            sb.append(URLEncoder.encode(HiidoConstantContent.mPackage, "UTF-8"));
            sb.append("&");
            sb.append(CLIENTVER);
            sb.append("=");
            sb.append(URLEncoder.encode(HiidoConstantContent.mClientVer, "UTF-8"));
            sb.append("&");
            sb.append("sys");
            sb.append("=");
            sb.append(URLEncoder.encode(HiidoConstantContent.mSYS, "UTF-8"));
            sb.append("&");
            sb.append("sjm");
            sb.append("=");
            sb.append(URLEncoder.encode(HiidoConstantContent.mDevice, "UTF-8"));
            sb.append("&");
            sb.append("mbos");
            sb.append("=");
            sb.append(URLEncoder.encode(HiidoConstantContent.mMBOS, "UTF-8"));
            String sb2 = sb.toString();
            Intrinsics.checkExpressionValueIsNotNull(sb2, "contents.toString()");
            return sb2;
        }
        return (String) invokeV.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.statistics.hiido.AbstractHiidoContent
    public Map<String, String> getMapContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("appid", this.mAppId);
            linkedHashMap.put(USECHANNEL, this.mUseChannel);
            linkedHashMap.put(HOSTID, this.mHostId);
            linkedHashMap.put("uid", this.mUid);
            String str = HiidoConstantContent.mSdkVer;
            Intrinsics.checkExpressionValueIsNotNull(str, "HiidoConstantContent.mSdkVer");
            linkedHashMap.put(SDKVER, str);
            String str2 = HiidoConstantContent.mPackage;
            Intrinsics.checkExpressionValueIsNotNull(str2, "HiidoConstantContent.mPackage");
            linkedHashMap.put(BUNDLEID, str2);
            String str3 = HiidoConstantContent.mClientVer;
            Intrinsics.checkExpressionValueIsNotNull(str3, "HiidoConstantContent.mClientVer");
            linkedHashMap.put(CLIENTVER, str3);
            String str4 = HiidoConstantContent.mSYS;
            Intrinsics.checkExpressionValueIsNotNull(str4, "HiidoConstantContent.mSYS");
            linkedHashMap.put("sys", str4);
            String str5 = HiidoConstantContent.mDevice;
            Intrinsics.checkExpressionValueIsNotNull(str5, "HiidoConstantContent.mDevice");
            linkedHashMap.put("sjm", str5);
            String str6 = HiidoConstantContent.mMBOS;
            Intrinsics.checkExpressionValueIsNotNull(str6, "HiidoConstantContent.mMBOS");
            linkedHashMap.put("mbos", str6);
            String str7 = HiidoConstantContent.mAppKey;
            Intrinsics.checkExpressionValueIsNotNull(str7, "HiidoConstantContent.mAppKey");
            linkedHashMap.put("appkey", str7);
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }

    public /* synthetic */ BaseHiidoContent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
