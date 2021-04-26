package tv.athena.revenue.api;

import android.content.Context;
import androidx.annotation.Keep;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.webkit.sdk.WebChromeClient;
import com.yy.mobile.framework.revenuesdk.baseapi.IToken;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import d.r.b.a.a.f.c.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000:\u0001`B\u0011\b\u0002\u0012\u0006\u0010]\u001a\u00020\\¢\u0006\u0004\b^\u0010_R$\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\"\u0010\u001f\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010+\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R\"\u00101\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0014\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\"\u00104\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0014\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\"\u00108\u001a\u0002078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010?\u001a\u0004\u0018\u00010>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\"\u0010E\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0014\u001a\u0004\bF\u0010\u0016\"\u0004\bG\u0010\u0018R$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010P\u001a\u00020O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010V\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bV\u0010\n\u001a\u0004\bW\u0010\f\"\u0004\bX\u0010\u000eR\"\u0010Y\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bY\u0010\u0014\u001a\u0004\bZ\u0010\u0016\"\u0004\b[\u0010\u0018¨\u0006a"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "getAppId", "()I", "setAppId", "(I)V", "authType", "getAuthType", "setAuthType", "", "country", "Ljava/lang/String;", "getCountry", "()Ljava/lang/String;", "setCountry", "(Ljava/lang/String;)V", "currencyType", "getCurrencyType", "setCurrencyType", "deviceId", "getDeviceId", "setDeviceId", "hostId", "getHostId", "setHostId", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "httpDataSender", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "getHttpDataSender", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "setHttpDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)V", "", "isOpenRisk", "Z", "()Z", "setOpenRisk", "(Z)V", "isTestEnv", "setTestEnv", "language", "getLanguage", "setLanguage", "packageName", "getPackageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "Ltv/athena/revenue/api/MiddleReportConfig;", "reportConfig", "Ltv/athena/revenue/api/MiddleReportConfig;", "getReportConfig", "()Ltv/athena/revenue/api/MiddleReportConfig;", "setReportConfig", "(Ltv/athena/revenue/api/MiddleReportConfig;)V", "token", "getToken", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "useChannel", "getUseChannel", "setUseChannel", "version", WebChromeClient.MSG_METHOD_GETVERSION, "setVersion", "Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "builder", "<init>", "(Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;)V", "MiddleRevenueConfigBuilder", "revenue-wrapper_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public final class MiddleRevenueConfig {
    public Context appContext;
    public int appId;
    public int authType;
    public String country;
    public int currencyType;
    public String deviceId;
    public String hostId;
    public b httpDataSender;
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b7\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\bi\u0010jJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u000bJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u000e¢\u0006\u0004\b!\u0010\u0011J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000e¢\u0006\u0004\b#\u0010\u0011J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0017\u0010*\u001a\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\u0015\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u001c¢\u0006\u0004\b-\u0010\u001fJ\u0015\u0010/\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u000e¢\u0006\u0004\b/\u0010\u0011J\u0017\u00102\u001a\u00020\u00002\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b2\u00103J\u0015\u00106\u001a\u00020\u00002\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u00020\u00002\u0006\u00108\u001a\u00020\b¢\u0006\u0004\b9\u0010\u000bJ\u0015\u0010;\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u000e¢\u0006\u0004\b;\u0010\u0011R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010<\u001a\u0004\b=\u0010>\"\u0004\b\u0006\u0010?R\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010@\u001a\u0004\bA\u0010B\"\u0004\b\n\u0010CR\"\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010@\u001a\u0004\bD\u0010B\"\u0004\b\r\u0010CR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010E\u001a\u0004\bF\u0010G\"\u0004\b\u0010\u0010HR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010@\u001a\u0004\bI\u0010B\"\u0004\b\u0013\u0010CR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010E\u001a\u0004\bJ\u0010G\"\u0004\b\u0015\u0010HR\"\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010E\u001a\u0004\bK\u0010G\"\u0004\b\u0017\u0010HR$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010L\u001a\u0004\bM\u0010N\"\u0004\b\u001a\u0010OR\"\u0010\u001d\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010P\u001a\u0004\b\u001d\u0010Q\"\u0004\bR\u0010SR\"\u0010,\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010P\u001a\u0004\b,\u0010Q\"\u0004\b-\u0010SR\"\u0010 \u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010E\u001a\u0004\bT\u0010G\"\u0004\b!\u0010HR\"\u0010\"\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010E\u001a\u0004\bU\u0010G\"\u0004\b#\u0010HR\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010V\u001a\u0004\bW\u0010X\"\u0004\b&\u0010YR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b*\u0010]R\"\u0010.\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010E\u001a\u0004\b^\u0010G\"\u0004\b/\u0010HR$\u00101\u001a\u0004\u0018\u0001008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010_\u001a\u0004\b`\u0010a\"\u0004\b2\u0010bR\"\u00105\u001a\u0002048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010c\u001a\u0004\bd\u0010e\"\u0004\b6\u0010fR\"\u00108\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010@\u001a\u0004\bg\u0010B\"\u0004\b9\u0010CR\"\u0010:\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b:\u0010E\u001a\u0004\bh\u0010G\"\u0004\b;\u0010H¨\u0006k"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleRevenueConfig;", "build", "()Ltv/athena/revenue/api/MiddleRevenueConfig;", "Landroid/content/Context;", "appContext", "setAppContext", "(Landroid/content/Context;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "setAppId", "(I)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "authType", "setAuthType", "", "country", "setCountry", "(Ljava/lang/String;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "currencyType", "setCurrencyType", "deviceId", "setDeviceId", "hostId", "setHostId", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "httpDataSender", "setHttpDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", "isOpenRisk", "setIsOpenRisk", "(Z)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "language", "setLanguage", "packageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleReportConfig;", "reportConfig", "setReportConfig", "(Ltv/athena/revenue/api/MiddleReportConfig;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "isTestEnv", "setTestEnv", "token", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", "uid", "setUid", "(J)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "useChannel", "setUseChannel", "version", "setVersion", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "(Landroid/content/Context;)V", "I", "getAppId", "()I", "(I)V", "getAuthType", "Ljava/lang/String;", "getCountry", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getCurrencyType", "getDeviceId", "getHostId", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "getHttpDataSender", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)V", "Z", "()Z", "setOpenRisk", "(Z)V", "getLanguage", "getPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "Ltv/athena/revenue/api/MiddleReportConfig;", "getReportConfig", "()Ltv/athena/revenue/api/MiddleReportConfig;", "(Ltv/athena/revenue/api/MiddleReportConfig;)V", "getToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "J", "getUid", "()J", "(J)V", "getUseChannel", WebChromeClient.MSG_METHOD_GETVERSION, "<init>", "()V", "revenue-wrapper_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes7.dex */
    public static final class MiddleRevenueConfigBuilder {
        public Context appContext;
        public int appId;
        public int authType;
        public int currencyType;
        public b httpDataSender;
        public boolean isOpenRisk;
        public MiddleReportConfig reportConfig;
        public IToken tokenCallback;
        public long uid;
        public int useChannel;
        public String packageName = "";
        public String version = "";
        public String language = "";
        public String country = "";
        public boolean isTestEnv = true;
        public ProtocolType protoType = ProtocolType.HTTP;
        public String token = "";
        public String hostId = "";
        public String deviceId = "";

        public final MiddleRevenueConfig build() {
            return new MiddleRevenueConfig(this, null);
        }

        public final Context getAppContext() {
            return this.appContext;
        }

        public final int getAppId() {
            return this.appId;
        }

        public final int getAuthType() {
            return this.authType;
        }

        public final String getCountry() {
            return this.country;
        }

        public final int getCurrencyType() {
            return this.currencyType;
        }

        public final String getDeviceId() {
            return this.deviceId;
        }

        public final String getHostId() {
            return this.hostId;
        }

        public final b getHttpDataSender() {
            return this.httpDataSender;
        }

        public final String getLanguage() {
            return this.language;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final ProtocolType getProtoType() {
            return this.protoType;
        }

        public final MiddleReportConfig getReportConfig() {
            return this.reportConfig;
        }

        public final String getToken() {
            return this.token;
        }

        public final IToken getTokenCallback() {
            return this.tokenCallback;
        }

        public final long getUid() {
            return this.uid;
        }

        public final int getUseChannel() {
            return this.useChannel;
        }

        public final String getVersion() {
            return this.version;
        }

        public final boolean isOpenRisk() {
            return this.isOpenRisk;
        }

        public final boolean isTestEnv() {
            return this.isTestEnv;
        }

        /* renamed from: setAppContext  reason: collision with other method in class */
        public final void m1995setAppContext(Context context) {
            this.appContext = context;
        }

        /* renamed from: setAppId  reason: collision with other method in class */
        public final void m1996setAppId(int i2) {
            this.appId = i2;
        }

        /* renamed from: setAuthType  reason: collision with other method in class */
        public final void m1997setAuthType(int i2) {
            this.authType = i2;
        }

        /* renamed from: setCountry  reason: collision with other method in class */
        public final void m1998setCountry(String str) {
            this.country = str;
        }

        /* renamed from: setCurrencyType  reason: collision with other method in class */
        public final void m1999setCurrencyType(int i2) {
            this.currencyType = i2;
        }

        /* renamed from: setDeviceId  reason: collision with other method in class */
        public final void m2000setDeviceId(String str) {
            this.deviceId = str;
        }

        /* renamed from: setHostId  reason: collision with other method in class */
        public final void m2001setHostId(String str) {
            this.hostId = str;
        }

        /* renamed from: setHttpDataSender  reason: collision with other method in class */
        public final void m2002setHttpDataSender(b bVar) {
            this.httpDataSender = bVar;
        }

        public final MiddleRevenueConfigBuilder setIsOpenRisk(boolean z) {
            this.isOpenRisk = z;
            return this;
        }

        /* renamed from: setLanguage  reason: collision with other method in class */
        public final void m2003setLanguage(String str) {
            this.language = str;
        }

        public final void setOpenRisk(boolean z) {
            this.isOpenRisk = z;
        }

        /* renamed from: setPackageName  reason: collision with other method in class */
        public final void m2004setPackageName(String str) {
            this.packageName = str;
        }

        /* renamed from: setProtoType  reason: collision with other method in class */
        public final void m2005setProtoType(ProtocolType protocolType) {
            this.protoType = protocolType;
        }

        /* renamed from: setReportConfig  reason: collision with other method in class */
        public final void m2006setReportConfig(MiddleReportConfig middleReportConfig) {
            this.reportConfig = middleReportConfig;
        }

        /* renamed from: setTestEnv  reason: collision with other method in class */
        public final void m2007setTestEnv(boolean z) {
            this.isTestEnv = z;
        }

        /* renamed from: setToken  reason: collision with other method in class */
        public final void m2008setToken(String str) {
            this.token = str;
        }

        /* renamed from: setTokenCallback  reason: collision with other method in class */
        public final void m2009setTokenCallback(IToken iToken) {
            this.tokenCallback = iToken;
        }

        /* renamed from: setUid  reason: collision with other method in class */
        public final void m2010setUid(long j) {
            this.uid = j;
        }

        /* renamed from: setUseChannel  reason: collision with other method in class */
        public final void m2011setUseChannel(int i2) {
            this.useChannel = i2;
        }

        /* renamed from: setVersion  reason: collision with other method in class */
        public final void m2012setVersion(String str) {
            this.version = str;
        }

        public final MiddleRevenueConfigBuilder setAppContext(Context context) {
            this.appContext = context;
            return this;
        }

        public final MiddleRevenueConfigBuilder setAppId(int i2) {
            this.appId = i2;
            return this;
        }

        public final MiddleRevenueConfigBuilder setAuthType(int i2) {
            this.authType = i2;
            return this;
        }

        public final MiddleRevenueConfigBuilder setCountry(String str) {
            this.country = str;
            return this;
        }

        public final MiddleRevenueConfigBuilder setCurrencyType(int i2) {
            this.currencyType = i2;
            return this;
        }

        public final MiddleRevenueConfigBuilder setDeviceId(String str) {
            this.deviceId = str;
            return this;
        }

        public final MiddleRevenueConfigBuilder setHostId(String str) {
            this.hostId = str;
            return this;
        }

        public final MiddleRevenueConfigBuilder setHttpDataSender(b bVar) {
            this.httpDataSender = bVar;
            return this;
        }

        public final MiddleRevenueConfigBuilder setLanguage(String str) {
            this.language = str;
            return this;
        }

        public final MiddleRevenueConfigBuilder setPackageName(String str) {
            this.packageName = str;
            return this;
        }

        public final MiddleRevenueConfigBuilder setProtoType(ProtocolType protocolType) {
            this.protoType = protocolType;
            return this;
        }

        public final MiddleRevenueConfigBuilder setReportConfig(MiddleReportConfig middleReportConfig) {
            this.reportConfig = middleReportConfig;
            return this;
        }

        public final MiddleRevenueConfigBuilder setTestEnv(boolean z) {
            this.isTestEnv = z;
            return this;
        }

        public final MiddleRevenueConfigBuilder setToken(String str) {
            this.token = str;
            return this;
        }

        public final MiddleRevenueConfigBuilder setTokenCallback(IToken iToken) {
            this.tokenCallback = iToken;
            return this;
        }

        public final MiddleRevenueConfigBuilder setUid(long j) {
            this.uid = j;
            return this;
        }

        public final MiddleRevenueConfigBuilder setUseChannel(int i2) {
            this.useChannel = i2;
            return this;
        }

        public final MiddleRevenueConfigBuilder setVersion(String str) {
            this.version = str;
            return this;
        }
    }

    public MiddleRevenueConfig(MiddleRevenueConfigBuilder middleRevenueConfigBuilder) {
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
        this.httpDataSender = middleRevenueConfigBuilder.getHttpDataSender();
        this.protoType = middleRevenueConfigBuilder.getProtoType();
        this.tokenCallback = middleRevenueConfigBuilder.getTokenCallback();
        this.token = middleRevenueConfigBuilder.getToken();
        this.uid = middleRevenueConfigBuilder.getUid();
        this.hostId = middleRevenueConfigBuilder.getHostId();
        this.deviceId = middleRevenueConfigBuilder.getDeviceId();
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final int getAppId() {
        return this.appId;
    }

    public final int getAuthType() {
        return this.authType;
    }

    public final String getCountry() {
        return this.country;
    }

    public final int getCurrencyType() {
        return this.currencyType;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getHostId() {
        return this.hostId;
    }

    public final b getHttpDataSender() {
        return this.httpDataSender;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final ProtocolType getProtoType() {
        return this.protoType;
    }

    public final MiddleReportConfig getReportConfig() {
        return this.reportConfig;
    }

    public final String getToken() {
        return this.token;
    }

    public final IToken getTokenCallback() {
        return this.tokenCallback;
    }

    public final long getUid() {
        return this.uid;
    }

    public final int getUseChannel() {
        return this.useChannel;
    }

    public final String getVersion() {
        return this.version;
    }

    public final boolean isOpenRisk() {
        return this.isOpenRisk;
    }

    public final boolean isTestEnv() {
        return this.isTestEnv;
    }

    public final void setAppContext(Context context) {
        this.appContext = context;
    }

    public final void setAppId(int i2) {
        this.appId = i2;
    }

    public final void setAuthType(int i2) {
        this.authType = i2;
    }

    public final void setCountry(String str) {
        this.country = str;
    }

    public final void setCurrencyType(int i2) {
        this.currencyType = i2;
    }

    public final void setDeviceId(String str) {
        this.deviceId = str;
    }

    public final void setHostId(String str) {
        this.hostId = str;
    }

    public final void setHttpDataSender(b bVar) {
        this.httpDataSender = bVar;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }

    public final void setOpenRisk(boolean z) {
        this.isOpenRisk = z;
    }

    public final void setPackageName(String str) {
        this.packageName = str;
    }

    public final void setProtoType(ProtocolType protocolType) {
        this.protoType = protocolType;
    }

    public final void setReportConfig(MiddleReportConfig middleReportConfig) {
        this.reportConfig = middleReportConfig;
    }

    public final void setTestEnv(boolean z) {
        this.isTestEnv = z;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final void setTokenCallback(IToken iToken) {
        this.tokenCallback = iToken;
    }

    public final void setUid(long j) {
        this.uid = j;
    }

    public final void setUseChannel(int i2) {
        this.useChannel = i2;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public /* synthetic */ MiddleRevenueConfig(MiddleRevenueConfigBuilder middleRevenueConfigBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(middleRevenueConfigBuilder);
    }
}
