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
import com.yy.mobile.framework.revenuesdk.baseapi.data.IDataSenderAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000:\u0001dB\u0011\b\u0002\u0012\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0003\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0003\"\u0004\b&\u0010\u0019R\"\u0010'\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0003\"\u0004\b)\u0010\u0019R\"\u0010*\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0003\"\u0004\b,\u0010\u0019R\"\u0010.\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\"\u00103\u001a\u00020-8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010/\u001a\u0004\b3\u00100\"\u0004\b4\u00102R\"\u00105\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010\u0016\u001a\u0004\b6\u0010\u0003\"\u0004\b7\u0010\u0019R\"\u00108\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0016\u001a\u0004\b9\u0010\u0003\"\u0004\b:\u0010\u0019R\"\u0010<\u001a\u00020;8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\"\u0010I\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010\u0016\u001a\u0004\bJ\u0010\u0003\"\u0004\bK\u0010\u0019R$\u0010M\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010T\u001a\u00020S8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\"\u0010Z\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bZ\u0010\r\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R\"\u0010]\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010\u0016\u001a\u0004\b^\u0010\u0003\"\u0004\b_\u0010\u0019¨\u0006e"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig;", "", "toString", "()Ljava/lang/String;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "getAppId", "()I", "setAppId", "(I)V", "authType", "getAuthType", "setAuthType", "country", "Ljava/lang/String;", "getCountry", "setCountry", "(Ljava/lang/String;)V", "currencyType", "getCurrencyType", "setCurrencyType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "dataSender", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "getDataSender", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "setDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)V", "deviceId", "getDeviceId", "setDeviceId", "gslbAppId", "getGslbAppId", "setGslbAppId", "hostId", "getHostId", "setHostId", "", "isOpenRisk", "Z", "()Z", "setOpenRisk", "(Z)V", "isTestEnv", "setTestEnv", "language", "getLanguage", "setLanguage", "packageName", "getPackageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "Ltv/athena/revenue/api/MiddleReportConfig;", "reportConfig", "Ltv/athena/revenue/api/MiddleReportConfig;", "getReportConfig", "()Ltv/athena/revenue/api/MiddleReportConfig;", "setReportConfig", "(Ltv/athena/revenue/api/MiddleReportConfig;)V", "token", "getToken", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "useChannel", "getUseChannel", "setUseChannel", "version", WebChromeClient.MSG_METHOD_GETVERSION, "setVersion", "Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "builder", "<init>", "(Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;)V", "MiddleRevenueConfigBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes2.dex */
public final class MiddleRevenueConfig {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context appContext;
    public int appId;
    public int authType;
    public String country;
    public int currencyType;
    public IDataSenderAdapter dataSender;
    public String deviceId;
    public String gslbAppId;
    public String hostId;
    public boolean isOpenRisk;
    public boolean isTestEnv;
    public String language;
    public String packageName;
    public ProtocolType protoType;
    public MiddleReportConfig reportConfig;
    public String token;
    public IToken tokenCallback;
    public long uid;
    public int useChannel;
    public String version;

    @Keep
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b:\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\bn\u0010oJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u000bJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0011J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b#\u0010\u0011J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u000e¢\u0006\u0004\b%\u0010\u0011J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\u00002\b\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u001e¢\u0006\u0004\b/\u0010!J\u0015\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u000e¢\u0006\u0004\b1\u0010\u0011J\u0017\u00104\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u000102¢\u0006\u0004\b4\u00105J\u0015\u00108\u001a\u00020\u00002\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0015\u0010;\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\b¢\u0006\u0004\b;\u0010\u000bJ\u0015\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\u000e¢\u0006\u0004\b=\u0010\u0011R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010>\u001a\u0004\b?\u0010@\"\u0004\b\u0006\u0010AR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010B\u001a\u0004\bC\u0010D\"\u0004\b\n\u0010ER\"\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010B\u001a\u0004\bF\u0010D\"\u0004\b\r\u0010ER\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010G\u001a\u0004\bH\u0010I\"\u0004\b\u0010\u0010JR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010B\u001a\u0004\bK\u0010D\"\u0004\b\u0013\u0010ER$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010G\u001a\u0004\bQ\u0010I\"\u0004\b\u0015\u0010JR\"\u0010R\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bR\u0010G\u001a\u0004\bS\u0010I\"\u0004\b\u0017\u0010JR\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010G\u001a\u0004\bT\u0010I\"\u0004\b\u0019\u0010JR\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010U\u001a\u0004\b\u001f\u0010V\"\u0004\bW\u0010XR\"\u0010.\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010U\u001a\u0004\b.\u0010V\"\u0004\b/\u0010XR\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010G\u001a\u0004\bY\u0010I\"\u0004\b#\u0010JR\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010G\u001a\u0004\bZ\u0010I\"\u0004\b%\u0010JR\"\u0010'\u001a\u00020&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b(\u0010^R$\u0010+\u001a\u0004\u0018\u00010*8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b+\u0010_\u001a\u0004\b`\u0010a\"\u0004\b,\u0010bR\"\u00100\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010G\u001a\u0004\bc\u0010I\"\u0004\b1\u0010JR$\u00103\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010d\u001a\u0004\be\u0010f\"\u0004\b4\u0010gR\"\u00107\u001a\u0002068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u0010h\u001a\u0004\bi\u0010j\"\u0004\b8\u0010kR\"\u0010:\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010B\u001a\u0004\bl\u0010D\"\u0004\b;\u0010ER\"\u0010<\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010G\u001a\u0004\bm\u0010I\"\u0004\b=\u0010J¨\u0006p"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleRevenueConfig;", "build", "()Ltv/athena/revenue/api/MiddleRevenueConfig;", "Landroid/content/Context;", "appContext", "setAppContext", "(Landroid/content/Context;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "setAppId", "(I)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "authType", "setAuthType", "", "country", "setCountry", "(Ljava/lang/String;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "currencyType", "setCurrencyType", "deviceId", "setDeviceId", "gslpAppId", "setGslbAppId", "hostId", "setHostId", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "dataSender", "setHttpDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", "isOpenRisk", "setIsOpenRisk", "(Z)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "language", "setLanguage", "packageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleReportConfig;", "reportConfig", "setReportConfig", "(Ltv/athena/revenue/api/MiddleReportConfig;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "isTestEnv", "setTestEnv", "token", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", "uid", "setUid", "(J)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "useChannel", "setUseChannel", "version", "setVersion", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "(Landroid/content/Context;)V", "I", "getAppId", "()I", "(I)V", "getAuthType", "Ljava/lang/String;", "getCountry", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getCurrencyType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "getDataSender", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "setDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)V", "getDeviceId", "gslbAppId", "getGslbAppId", "getHostId", "Z", "()Z", "setOpenRisk", "(Z)V", "getLanguage", "getPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "Ltv/athena/revenue/api/MiddleReportConfig;", "getReportConfig", "()Ltv/athena/revenue/api/MiddleReportConfig;", "(Ltv/athena/revenue/api/MiddleReportConfig;)V", "getToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "J", "getUid", "()J", "(J)V", "getUseChannel", WebChromeClient.MSG_METHOD_GETVERSION, "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes2.dex */
    public static final class MiddleRevenueConfigBuilder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Context appContext;
        public int appId;
        public int authType;
        public String country;
        public int currencyType;
        public IDataSenderAdapter dataSender;
        public String deviceId;
        public String gslbAppId;
        public String hostId;
        public boolean isOpenRisk;
        public boolean isTestEnv;
        public String language;
        public String packageName;
        public ProtocolType protoType;
        public MiddleReportConfig reportConfig;
        public String token;
        public IToken tokenCallback;
        public long uid;
        public int useChannel;
        public String version;

        public MiddleRevenueConfigBuilder() {
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
            this.packageName = "";
            this.version = "";
            this.language = "";
            this.country = "";
            this.isTestEnv = true;
            this.protoType = ProtocolType.HTTP;
            this.token = "";
            this.hostId = "";
            this.deviceId = "";
            this.gslbAppId = "";
        }

        public final MiddleRevenueConfig build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new MiddleRevenueConfig(this, null) : (MiddleRevenueConfig) invokeV.objValue;
        }

        public final Context getAppContext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appContext : (Context) invokeV.objValue;
        }

        public final int getAppId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.appId : invokeV.intValue;
        }

        public final int getAuthType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.authType : invokeV.intValue;
        }

        public final String getCountry() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.country : (String) invokeV.objValue;
        }

        public final int getCurrencyType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.currencyType : invokeV.intValue;
        }

        public final IDataSenderAdapter getDataSender() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.dataSender : (IDataSenderAdapter) invokeV.objValue;
        }

        public final String getDeviceId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.deviceId : (String) invokeV.objValue;
        }

        public final String getGslbAppId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.gslbAppId : (String) invokeV.objValue;
        }

        public final String getHostId() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.hostId : (String) invokeV.objValue;
        }

        public final String getLanguage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.language : (String) invokeV.objValue;
        }

        public final String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.packageName : (String) invokeV.objValue;
        }

        public final ProtocolType getProtoType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.protoType : (ProtocolType) invokeV.objValue;
        }

        public final MiddleReportConfig getReportConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.reportConfig : (MiddleReportConfig) invokeV.objValue;
        }

        public final String getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.token : (String) invokeV.objValue;
        }

        public final IToken getTokenCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.tokenCallback : (IToken) invokeV.objValue;
        }

        public final long getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.uid : invokeV.longValue;
        }

        public final int getUseChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.useChannel : invokeV.intValue;
        }

        public final String getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.version : (String) invokeV.objValue;
        }

        public final boolean isOpenRisk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.isOpenRisk : invokeV.booleanValue;
        }

        public final boolean isTestEnv() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.isTestEnv : invokeV.booleanValue;
        }

        /* renamed from: setAppContext  reason: collision with other method in class */
        public final void m2011setAppContext(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048598, this, context) == null) {
                this.appContext = context;
            }
        }

        /* renamed from: setAppId  reason: collision with other method in class */
        public final void m2012setAppId(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
                this.appId = i2;
            }
        }

        /* renamed from: setAuthType  reason: collision with other method in class */
        public final void m2013setAuthType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
                this.authType = i2;
            }
        }

        /* renamed from: setCountry  reason: collision with other method in class */
        public final void m2014setCountry(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
                this.country = str;
            }
        }

        /* renamed from: setCurrencyType  reason: collision with other method in class */
        public final void m2015setCurrencyType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
                this.currencyType = i2;
            }
        }

        public final void setDataSender(IDataSenderAdapter iDataSenderAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048607, this, iDataSenderAdapter) == null) {
                this.dataSender = iDataSenderAdapter;
            }
        }

        /* renamed from: setDeviceId  reason: collision with other method in class */
        public final void m2016setDeviceId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
                this.deviceId = str;
            }
        }

        /* renamed from: setGslbAppId  reason: collision with other method in class */
        public final void m2017setGslbAppId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
                this.gslbAppId = str;
            }
        }

        /* renamed from: setHostId  reason: collision with other method in class */
        public final void m2018setHostId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
                this.hostId = str;
            }
        }

        public final MiddleRevenueConfigBuilder setHttpDataSender(IDataSenderAdapter iDataSenderAdapter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048614, this, iDataSenderAdapter)) == null) {
                this.dataSender = iDataSenderAdapter;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setIsOpenRisk(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048615, this, z)) == null) {
                this.isOpenRisk = z;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeZ.objValue;
        }

        /* renamed from: setLanguage  reason: collision with other method in class */
        public final void m2019setLanguage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
                this.language = str;
            }
        }

        public final void setOpenRisk(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048618, this, z) == null) {
                this.isOpenRisk = z;
            }
        }

        /* renamed from: setPackageName  reason: collision with other method in class */
        public final void m2020setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
                this.packageName = str;
            }
        }

        /* renamed from: setProtoType  reason: collision with other method in class */
        public final void m2021setProtoType(ProtocolType protocolType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048622, this, protocolType) == null) {
                this.protoType = protocolType;
            }
        }

        /* renamed from: setReportConfig  reason: collision with other method in class */
        public final void m2022setReportConfig(MiddleReportConfig middleReportConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048624, this, middleReportConfig) == null) {
                this.reportConfig = middleReportConfig;
            }
        }

        /* renamed from: setTestEnv  reason: collision with other method in class */
        public final void m2023setTestEnv(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048626, this, z) == null) {
                this.isTestEnv = z;
            }
        }

        /* renamed from: setToken  reason: collision with other method in class */
        public final void m2024setToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048628, this, str) == null) {
                this.token = str;
            }
        }

        /* renamed from: setTokenCallback  reason: collision with other method in class */
        public final void m2025setTokenCallback(IToken iToken) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048630, this, iToken) == null) {
                this.tokenCallback = iToken;
            }
        }

        /* renamed from: setUid  reason: collision with other method in class */
        public final void m2026setUid(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048632, this, j2) == null) {
                this.uid = j2;
            }
        }

        /* renamed from: setUseChannel  reason: collision with other method in class */
        public final void m2027setUseChannel(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048634, this, i2) == null) {
                this.useChannel = i2;
            }
        }

        /* renamed from: setVersion  reason: collision with other method in class */
        public final void m2028setVersion(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048636, this, str) == null) {
                this.version = str;
            }
        }

        public final MiddleRevenueConfigBuilder setAppContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, context)) == null) {
                this.appContext = context;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setAppId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048599, this, i2)) == null) {
                this.appId = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setAuthType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) {
                this.authType = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setCountry(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
                this.country = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setCurrencyType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048605, this, i2)) == null) {
                this.currencyType = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setDeviceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, str)) == null) {
                this.deviceId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setGslbAppId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, str)) == null) {
                this.gslbAppId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setHostId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, str)) == null) {
                this.hostId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setLanguage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
                this.language = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setPackageName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
                this.packageName = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setProtoType(ProtocolType protocolType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048621, this, protocolType)) == null) {
                this.protoType = protocolType;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setReportConfig(MiddleReportConfig middleReportConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, middleReportConfig)) == null) {
                this.reportConfig = middleReportConfig;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setTestEnv(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
                this.isTestEnv = z;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeZ.objValue;
        }

        public final MiddleRevenueConfigBuilder setToken(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048627, this, str)) == null) {
                this.token = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setTokenCallback(IToken iToken) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048629, this, iToken)) == null) {
                this.tokenCallback = iToken;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setUid(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048631, this, j2)) == null) {
                this.uid = j2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeJ.objValue;
        }

        public final MiddleRevenueConfigBuilder setUseChannel(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048633, this, i2)) == null) {
                this.useChannel = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setVersion(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048635, this, str)) == null) {
                this.version = str;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.packageName = "";
        this.version = "";
        this.language = "";
        this.country = "";
        this.authType = 4;
        this.isTestEnv = true;
        this.protoType = ProtocolType.HTTP;
        this.token = "";
        this.hostId = "";
        this.deviceId = "";
        this.gslbAppId = "";
        this.appContext = middleRevenueConfigBuilder.getAppContext();
        this.appId = middleRevenueConfigBuilder.getAppId();
        this.useChannel = middleRevenueConfigBuilder.getUseChannel();
        this.currencyType = middleRevenueConfigBuilder.getCurrencyType();
        this.packageName = middleRevenueConfigBuilder.getPackageName();
        this.version = middleRevenueConfigBuilder.getVersion();
        this.language = middleRevenueConfigBuilder.getLanguage();
        this.country = middleRevenueConfigBuilder.getCountry();
        this.isOpenRisk = middleRevenueConfigBuilder.isOpenRisk();
        this.authType = middleRevenueConfigBuilder.getAuthType();
        this.reportConfig = middleRevenueConfigBuilder.getReportConfig();
        this.isTestEnv = middleRevenueConfigBuilder.isTestEnv();
        this.dataSender = middleRevenueConfigBuilder.getDataSender();
        this.protoType = middleRevenueConfigBuilder.getProtoType();
        this.tokenCallback = middleRevenueConfigBuilder.getTokenCallback();
        this.token = middleRevenueConfigBuilder.getToken();
        this.uid = middleRevenueConfigBuilder.getUid();
        this.hostId = middleRevenueConfigBuilder.getHostId();
        this.deviceId = middleRevenueConfigBuilder.getDeviceId();
        this.gslbAppId = middleRevenueConfigBuilder.getGslbAppId();
    }

    public final Context getAppContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.appContext : (Context) invokeV.objValue;
    }

    public final int getAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.appId : invokeV.intValue;
    }

    public final int getAuthType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.authType : invokeV.intValue;
    }

    public final String getCountry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.country : (String) invokeV.objValue;
    }

    public final int getCurrencyType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.currencyType : invokeV.intValue;
    }

    public final IDataSenderAdapter getDataSender() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.dataSender : (IDataSenderAdapter) invokeV.objValue;
    }

    public final String getDeviceId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.deviceId : (String) invokeV.objValue;
    }

    public final String getGslbAppId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.gslbAppId : (String) invokeV.objValue;
    }

    public final String getHostId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.hostId : (String) invokeV.objValue;
    }

    public final String getLanguage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.language : (String) invokeV.objValue;
    }

    public final String getPackageName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.packageName : (String) invokeV.objValue;
    }

    public final ProtocolType getProtoType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.protoType : (ProtocolType) invokeV.objValue;
    }

    public final MiddleReportConfig getReportConfig() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.reportConfig : (MiddleReportConfig) invokeV.objValue;
    }

    public final String getToken() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.token : (String) invokeV.objValue;
    }

    public final IToken getTokenCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.tokenCallback : (IToken) invokeV.objValue;
    }

    public final long getUid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.uid : invokeV.longValue;
    }

    public final int getUseChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.useChannel : invokeV.intValue;
    }

    public final String getVersion() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.version : (String) invokeV.objValue;
    }

    public final boolean isOpenRisk() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.isOpenRisk : invokeV.booleanValue;
    }

    public final boolean isTestEnv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.isTestEnv : invokeV.booleanValue;
    }

    public final void setAppContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, context) == null) {
            this.appContext = context;
        }
    }

    public final void setAppId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048597, this, i2) == null) {
            this.appId = i2;
        }
    }

    public final void setAuthType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.authType = i2;
        }
    }

    public final void setCountry(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.country = str;
        }
    }

    public final void setCurrencyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048600, this, i2) == null) {
            this.currencyType = i2;
        }
    }

    public final void setDataSender(IDataSenderAdapter iDataSenderAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, iDataSenderAdapter) == null) {
            this.dataSender = iDataSenderAdapter;
        }
    }

    public final void setDeviceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.deviceId = str;
        }
    }

    public final void setGslbAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.gslbAppId = str;
        }
    }

    public final void setHostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.hostId = str;
        }
    }

    public final void setLanguage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.language = str;
        }
    }

    public final void setOpenRisk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048606, this, z) == null) {
            this.isOpenRisk = z;
        }
    }

    public final void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.packageName = str;
        }
    }

    public final void setProtoType(ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, protocolType) == null) {
            this.protoType = protocolType;
        }
    }

    public final void setReportConfig(MiddleReportConfig middleReportConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, middleReportConfig) == null) {
            this.reportConfig = middleReportConfig;
        }
    }

    public final void setTestEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048610, this, z) == null) {
            this.isTestEnv = z;
        }
    }

    public final void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, str) == null) {
            this.token = str;
        }
    }

    public final void setTokenCallback(IToken iToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, iToken) == null) {
            this.tokenCallback = iToken;
        }
    }

    public final void setUid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048613, this, j2) == null) {
            this.uid = j2;
        }
    }

    public final void setUseChannel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048614, this, i2) == null) {
            this.useChannel = i2;
        }
    }

    public final void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, str) == null) {
            this.version = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return "MiddleRevenueConfig(appContext=" + this.appContext + ", appId=" + this.appId + ", useChannel=" + this.useChannel + StringUtil.ARRAY_ELEMENT_SEPARATOR + "currencyType=" + this.currencyType + ", packageName='" + this.packageName + "', version='" + this.version + "', language='" + this.language + "', country='" + this.country + "', isOpenRisk=" + this.isOpenRisk + ", authType=" + this.authType + ", reportConfig=" + this.reportConfig + StringUtil.ARRAY_ELEMENT_SEPARATOR + "isTestEnv=" + this.isTestEnv + ", dataSender=" + this.dataSender + ", protoType=" + this.protoType + StringUtil.ARRAY_ELEMENT_SEPARATOR + "tokenCallback=" + this.tokenCallback + ", uid=" + this.uid + ", hostId=" + this.hostId + ')';
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ MiddleRevenueConfig(MiddleRevenueConfigBuilder middleRevenueConfigBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(middleRevenueConfigBuilder);
    }
}
