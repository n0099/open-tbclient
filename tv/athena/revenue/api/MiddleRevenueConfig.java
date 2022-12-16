package tv.athena.revenue.api;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000:\u0001TB\u0011\b\u0002\u0012\u0006\u0010Q\u001a\u00020P¢\u0006\u0004\bR\u0010SJ\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0003\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R\"\u0010\u001d\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0013\u001a\u0004\b\u001e\u0010\u0003\"\u0004\b\u001f\u0010\u0016R\"\u0010 \u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b!\u0010\u0003\"\u0004\b\"\u0010\u0016R\"\u0010#\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010\u0003\"\u0004\b%\u0010\u0016R\"\u0010&\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0013\u001a\u0004\b'\u0010\u0003\"\u0004\b(\u0010\u0016R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\u0003\"\u0004\b1\u0010\u0016R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010\u0013\u001a\u0004\b:\u0010\u0003\"\u0004\b;\u0010\u0016R$\u0010=\u001a\u0004\u0018\u00010<8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010D\u001a\u00020C8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\"\u0010J\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bJ\u0010\r\u001a\u0004\bK\u0010\u000f\"\u0004\bL\u0010\u0011R\"\u0010M\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010\u0013\u001a\u0004\bN\u0010\u0003\"\u0004\bO\u0010\u0016¨\u0006U"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig;", "", "toString", "()Ljava/lang/String;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "getAppId", "()I", "setAppId", "(I)V", "appName", "Ljava/lang/String;", "getAppName", "setAppName", "(Ljava/lang/String;)V", "authType", "getAuthType", "setAuthType", "currencyType", "getCurrencyType", "setCurrencyType", "deviceId", "getDeviceId", "setDeviceId", "gslbAppId", "getGslbAppId", "setGslbAppId", "hostId", "getHostId", "setHostId", "httpUrl", "getHttpUrl", "setHttpUrl", "", "isTestEnv", "Z", "()Z", "setTestEnv", "(Z)V", "packageName", "getPackageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "token", "getToken", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "useChannel", "getUseChannel", "setUseChannel", "version", WebChromeClient.MSG_METHOD_GETVERSION, "setVersion", "Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "builder", "<init>", "(Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;)V", "MiddleRevenueConfigBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes9.dex */
public final class MiddleRevenueConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context appContext;
    public int appId;
    public String appName;
    public int authType;
    public int currencyType;
    public String deviceId;
    public String gslbAppId;
    public String hostId;
    public String httpUrl;
    public boolean isTestEnv;
    public String packageName;
    public ProtocolType protoType;
    public String token;
    public IToken tokenCallback;
    public long uid;
    public int useChannel;
    public String version;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b0\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\bd\u0010eJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0013\u0010\u000fJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u000bJ\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u000fJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u000fJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\f¢\u0006\u0004\b\u001d\u0010\u000fJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001eH\u0007¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\fH\u0007¢\u0006\u0004\b#\u0010\u000fJ\u0015\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\f¢\u0006\u0004\b%\u0010\u000fJ\u0015\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0019\u0010,\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u001e¢\u0006\u0004\b/\u0010!J\u0015\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\f¢\u0006\u0004\b1\u0010\u000fJ\u0017\u00104\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010;\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\b¢\u0006\u0004\b;\u0010\u000bJ\u0015\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\f¢\u0006\u0004\b=\u0010\u000fR$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010>\u001a\u0004\b?\u0010@\"\u0004\b\u0006\u0010AR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010D\"\u0004\b\n\u0010ER\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010F\u001a\u0004\bG\u0010H\"\u0004\b\u000e\u0010IR\"\u0010\u0010\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010B\u001a\u0004\bJ\u0010D\"\u0004\b\u0011\u0010ER\"\u0010\u0014\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010B\u001a\u0004\bK\u0010D\"\u0004\b\u0015\u0010ER\"\u0010\u0016\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010F\u001a\u0004\bL\u0010H\"\u0004\b\u0017\u0010IR\"\u0010M\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010F\u001a\u0004\bN\u0010H\"\u0004\b\u0019\u0010IR\"\u0010\u001a\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010F\u001a\u0004\bO\u0010H\"\u0004\b\u001b\u0010IR\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010F\u001a\u0004\bP\u0010H\"\u0004\b\u001d\u0010IR\"\u0010.\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010Q\u001a\u0004\b.\u0010R\"\u0004\b/\u0010SR\"\u0010$\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010F\u001a\u0004\bT\u0010H\"\u0004\b%\u0010IR\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010U\u001a\u0004\bV\u0010W\"\u0004\b(\u0010XR\"\u00100\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010F\u001a\u0004\bY\u0010H\"\u0004\b1\u0010IR$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b4\u0010]R\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010^\u001a\u0004\b_\u0010`\"\u0004\b8\u0010aR\"\u0010:\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010B\u001a\u0004\bb\u0010D\"\u0004\b;\u0010ER\"\u0010<\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010F\u001a\u0004\bc\u0010H\"\u0004\b=\u0010I¨\u0006f"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleRevenueConfig;", "build", "()Ltv/athena/revenue/api/MiddleRevenueConfig;", "Landroid/content/Context;", "appContext", "setAppContext", "(Landroid/content/Context;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "setAppId", "(I)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", "appName", "setAppName", "(Ljava/lang/String;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "authType", "setAuthType", "country", "setCountry", "currencyType", "setCurrencyType", "deviceId", "setDeviceId", "gslpAppId", "setGslbAppId", "hostId", "setHostId", "httpUrl", "setHttpUrl", "", "isOpenRisk", "setIsOpenRisk", "(Z)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "language", "setLanguage", "packageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleReportConfig;", "reportConfig", "setReportConfig", "(Ltv/athena/revenue/api/MiddleReportConfig;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "isTestEnv", "setTestEnv", "token", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", "uid", "setUid", "(J)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "useChannel", "setUseChannel", "version", "setVersion", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "(Landroid/content/Context;)V", "I", "getAppId", "()I", "(I)V", "Ljava/lang/String;", "getAppName", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getAuthType", "getCurrencyType", "getDeviceId", "gslbAppId", "getGslbAppId", "getHostId", "getHttpUrl", "Z", "()Z", "(Z)V", "getPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "getToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "J", "getUid", "()J", "(J)V", "getUseChannel", WebChromeClient.MSG_METHOD_GETVERSION, "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes9.dex */
    public static final class MiddleRevenueConfigBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context appContext;
        public int appId;
        public String appName;
        public int authType;
        public int currencyType;
        public String deviceId;
        public String gslbAppId;
        public String hostId;
        public String httpUrl;
        public boolean isTestEnv;
        public String packageName;
        public ProtocolType protoType;
        public String token;
        public IToken tokenCallback;
        public long uid;
        public int useChannel;
        public String version;

        @Deprecated(message = "废弃不再支持")
        public final MiddleRevenueConfigBuilder setCountry(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, str)) == null) ? this : (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        @Deprecated(message = "废弃不再支持")
        public final MiddleRevenueConfigBuilder setIsOpenRisk(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048613, this, z)) == null) ? this : (MiddleRevenueConfigBuilder) invokeZ.objValue;
        }

        @Deprecated(message = "废弃不再支持")
        public final MiddleRevenueConfigBuilder setLanguage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, str)) == null) ? this : (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public MiddleRevenueConfigBuilder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.packageName = "";
            this.version = "";
            this.isTestEnv = true;
            this.protoType = ProtocolType.HTTP;
            this.token = "";
            this.hostId = "";
            this.deviceId = "";
            this.gslbAppId = "";
            this.httpUrl = "";
            this.appName = "";
        }

        public final MiddleRevenueConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new MiddleRevenueConfig(this, null);
            }
            return (MiddleRevenueConfig) invokeV.objValue;
        }

        public final Context getAppContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return this.appContext;
            }
            return (Context) invokeV.objValue;
        }

        public final int getAppId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return this.appId;
            }
            return invokeV.intValue;
        }

        public final String getAppName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                return this.appName;
            }
            return (String) invokeV.objValue;
        }

        public final int getAuthType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                return this.authType;
            }
            return invokeV.intValue;
        }

        public final int getCurrencyType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.currencyType;
            }
            return invokeV.intValue;
        }

        public final String getDeviceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return this.deviceId;
            }
            return (String) invokeV.objValue;
        }

        public final String getGslbAppId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                return this.gslbAppId;
            }
            return (String) invokeV.objValue;
        }

        public final String getHostId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return this.hostId;
            }
            return (String) invokeV.objValue;
        }

        public final String getHttpUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return this.httpUrl;
            }
            return (String) invokeV.objValue;
        }

        public final String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.packageName;
            }
            return (String) invokeV.objValue;
        }

        public final ProtocolType getProtoType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.protoType;
            }
            return (ProtocolType) invokeV.objValue;
        }

        public final String getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.token;
            }
            return (String) invokeV.objValue;
        }

        public final IToken getTokenCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.tokenCallback;
            }
            return (IToken) invokeV.objValue;
        }

        public final long getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                return this.uid;
            }
            return invokeV.longValue;
        }

        public final int getUseChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
                return this.useChannel;
            }
            return invokeV.intValue;
        }

        public final String getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
                return this.version;
            }
            return (String) invokeV.objValue;
        }

        public final boolean isTestEnv() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
                return this.isTestEnv;
            }
            return invokeV.booleanValue;
        }

        public final MiddleRevenueConfigBuilder setAppContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, context)) == null) {
                this.appContext = context;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setAppId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048596, this, i)) == null) {
                this.appId = i;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setAppName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, str)) == null) {
                this.appName = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setAuthType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i)) == null) {
                this.authType = i;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setCurrencyType(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048603, this, i)) == null) {
                this.currencyType = i;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setDeviceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, str)) == null) {
                this.deviceId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setGslbAppId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, str)) == null) {
                this.gslbAppId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setHostId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
                this.hostId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setHttpUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
                this.httpUrl = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setPackageName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, str)) == null) {
                this.packageName = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setProtoType(ProtocolType protocolType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, protocolType)) == null) {
                this.protoType = protocolType;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setTestEnv(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048620, this, z)) == null) {
                this.isTestEnv = z;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeZ.objValue;
        }

        public final MiddleRevenueConfigBuilder setToken(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
                this.token = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setTokenCallback(IToken iToken) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, iToken)) == null) {
                this.tokenCallback = iToken;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setUid(long j) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048626, this, j)) == null) {
                this.uid = j;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeJ.objValue;
        }

        public final MiddleRevenueConfigBuilder setUseChannel(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i)) == null) {
                this.useChannel = i;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setVersion(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
                this.version = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        /* renamed from: setAppContext  reason: collision with other method in class */
        public final void m2131setAppContext(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
                this.appContext = context;
            }
        }

        /* renamed from: setAppId  reason: collision with other method in class */
        public final void m2132setAppId(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
                this.appId = i;
            }
        }

        /* renamed from: setAppName  reason: collision with other method in class */
        public final void m2133setAppName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
                this.appName = str;
            }
        }

        /* renamed from: setAuthType  reason: collision with other method in class */
        public final void m2134setAuthType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i) == null) {
                this.authType = i;
            }
        }

        /* renamed from: setCurrencyType  reason: collision with other method in class */
        public final void m2135setCurrencyType(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048604, this, i) == null) {
                this.currencyType = i;
            }
        }

        /* renamed from: setDeviceId  reason: collision with other method in class */
        public final void m2136setDeviceId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
                this.deviceId = str;
            }
        }

        /* renamed from: setGslbAppId  reason: collision with other method in class */
        public final void m2137setGslbAppId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, str) == null) {
                this.gslbAppId = str;
            }
        }

        /* renamed from: setHostId  reason: collision with other method in class */
        public final void m2138setHostId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
                this.hostId = str;
            }
        }

        /* renamed from: setHttpUrl  reason: collision with other method in class */
        public final void m2139setHttpUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
                this.httpUrl = str;
            }
        }

        /* renamed from: setPackageName  reason: collision with other method in class */
        public final void m2140setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048616, this, str) == null) {
                this.packageName = str;
            }
        }

        /* renamed from: setProtoType  reason: collision with other method in class */
        public final void m2141setProtoType(ProtocolType protocolType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048618, this, protocolType) == null) {
                this.protoType = protocolType;
            }
        }

        /* renamed from: setTestEnv  reason: collision with other method in class */
        public final void m2142setTestEnv(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
                this.isTestEnv = z;
            }
        }

        /* renamed from: setToken  reason: collision with other method in class */
        public final void m2143setToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
                this.token = str;
            }
        }

        /* renamed from: setTokenCallback  reason: collision with other method in class */
        public final void m2144setTokenCallback(IToken iToken) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048625, this, iToken) == null) {
                this.tokenCallback = iToken;
            }
        }

        /* renamed from: setUid  reason: collision with other method in class */
        public final void m2145setUid(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048627, this, j) == null) {
                this.uid = j;
            }
        }

        /* renamed from: setUseChannel  reason: collision with other method in class */
        public final void m2146setUseChannel(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048629, this, i) == null) {
                this.useChannel = i;
            }
        }

        /* renamed from: setVersion  reason: collision with other method in class */
        public final void m2147setVersion(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
                this.version = str;
            }
        }

        @Deprecated(message = "过时接口,使用新接口替换 setAppName setDeviceId")
        public final MiddleRevenueConfigBuilder setReportConfig(MiddleReportConfig middleReportConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, middleReportConfig)) == null) {
                RLog.info("MiddleRevenueConfig", "setReportConfig reportConfig:" + middleReportConfig);
                if (middleReportConfig != null) {
                    this.appName = middleReportConfig.getAppName();
                    this.deviceId = middleReportConfig.getDeviceId();
                }
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }
    }

    public MiddleRevenueConfig(MiddleRevenueConfigBuilder middleRevenueConfigBuilder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {middleRevenueConfigBuilder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.packageName = "";
        this.version = "";
        this.authType = 4;
        this.isTestEnv = true;
        this.protoType = ProtocolType.HTTP;
        this.token = "";
        this.hostId = "";
        this.deviceId = "";
        this.gslbAppId = "";
        this.httpUrl = "";
        this.appName = "";
        this.appContext = middleRevenueConfigBuilder.getAppContext();
        this.appId = middleRevenueConfigBuilder.getAppId();
        this.useChannel = middleRevenueConfigBuilder.getUseChannel();
        this.currencyType = middleRevenueConfigBuilder.getCurrencyType();
        this.packageName = middleRevenueConfigBuilder.getPackageName();
        this.version = middleRevenueConfigBuilder.getVersion();
        this.authType = middleRevenueConfigBuilder.getAuthType();
        this.isTestEnv = middleRevenueConfigBuilder.isTestEnv();
        this.protoType = middleRevenueConfigBuilder.getProtoType();
        this.tokenCallback = middleRevenueConfigBuilder.getTokenCallback();
        this.token = middleRevenueConfigBuilder.getToken();
        this.uid = middleRevenueConfigBuilder.getUid();
        this.hostId = middleRevenueConfigBuilder.getHostId();
        this.deviceId = middleRevenueConfigBuilder.getDeviceId();
        this.gslbAppId = middleRevenueConfigBuilder.getGslbAppId();
        this.httpUrl = middleRevenueConfigBuilder.getHttpUrl();
        this.appName = middleRevenueConfigBuilder.getAppName();
    }

    public /* synthetic */ MiddleRevenueConfig(MiddleRevenueConfigBuilder middleRevenueConfigBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(middleRevenueConfigBuilder);
    }

    public final Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.appContext;
        }
        return (Context) invokeV.objValue;
    }

    public final int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.appId;
        }
        return invokeV.intValue;
    }

    public final String getAppName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.appName;
        }
        return (String) invokeV.objValue;
    }

    public final int getAuthType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.authType;
        }
        return invokeV.intValue;
    }

    public final int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.currencyType;
        }
        return invokeV.intValue;
    }

    public final String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.deviceId;
        }
        return (String) invokeV.objValue;
    }

    public final String getGslbAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.gslbAppId;
        }
        return (String) invokeV.objValue;
    }

    public final String getHostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.hostId;
        }
        return (String) invokeV.objValue;
    }

    public final String getHttpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.httpUrl;
        }
        return (String) invokeV.objValue;
    }

    public final String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.packageName;
        }
        return (String) invokeV.objValue;
    }

    public final ProtocolType getProtoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.protoType;
        }
        return (ProtocolType) invokeV.objValue;
    }

    public final String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.token;
        }
        return (String) invokeV.objValue;
    }

    public final IToken getTokenCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.tokenCallback;
        }
        return (IToken) invokeV.objValue;
    }

    public final long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return this.uid;
        }
        return invokeV.longValue;
    }

    public final int getUseChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.useChannel;
        }
        return invokeV.intValue;
    }

    public final String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.version;
        }
        return (String) invokeV.objValue;
    }

    public final boolean isTestEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.isTestEnv;
        }
        return invokeV.booleanValue;
    }

    public final void setAppContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, context) == null) {
            this.appContext = context;
        }
    }

    public final void setAppId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.appId = i;
        }
    }

    public final void setAppName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            this.appName = str;
        }
    }

    public final void setAuthType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.authType = i;
        }
    }

    public final void setCurrencyType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i) == null) {
            this.currencyType = i;
        }
    }

    public final void setDeviceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.deviceId = str;
        }
    }

    public final void setGslbAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.gslbAppId = str;
        }
    }

    public final void setHostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.hostId = str;
        }
    }

    public final void setHttpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.httpUrl = str;
        }
    }

    public final void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.packageName = str;
        }
    }

    public final void setProtoType(ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, protocolType) == null) {
            this.protoType = protocolType;
        }
    }

    public final void setTestEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            this.isTestEnv = z;
        }
    }

    public final void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.token = str;
        }
    }

    public final void setTokenCallback(IToken iToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, iToken) == null) {
            this.tokenCallback = iToken;
        }
    }

    public final void setUid(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048607, this, j) == null) {
            this.uid = j;
        }
    }

    public final void setUseChannel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.useChannel = i;
        }
    }

    public final void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.version = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return "MiddleRevenueConfig(appContext=" + this.appContext + ", appId=" + this.appId + ", useChannel=" + this.useChannel + StringUtil.ARRAY_ELEMENT_SEPARATOR + "currencyType=" + this.currencyType + ", packageName='" + this.packageName + "', version='" + this.version + "', authType=" + this.authType + ", appName=" + this.appName + ", deviceId=" + this.deviceId + StringUtil.ARRAY_ELEMENT_SEPARATOR + "isTestEnv=" + this.isTestEnv + ", protoType=" + this.protoType + StringUtil.ARRAY_ELEMENT_SEPARATOR + "tokenCallback=" + this.tokenCallback + ", hostId=" + this.hostId + ')';
        }
        return (String) invokeV.objValue;
    }
}
