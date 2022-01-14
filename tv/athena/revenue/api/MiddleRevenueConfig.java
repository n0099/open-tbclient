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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000:\u0001gB\u0011\b\u0002\u0012\u0006\u0010d\u001a\u00020c¢\u0006\u0004\be\u0010fJ\u000f\u0010\u0002\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\"\u0010\u0015\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0003\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011R$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010$\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0003\"\u0004\b&\u0010\u0019R\"\u0010'\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010\u0016\u001a\u0004\b(\u0010\u0003\"\u0004\b)\u0010\u0019R\"\u0010*\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0016\u001a\u0004\b+\u0010\u0003\"\u0004\b,\u0010\u0019R\"\u0010-\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010\u0016\u001a\u0004\b.\u0010\u0003\"\u0004\b/\u0010\u0019R\"\u00101\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\"\u00106\u001a\u0002008\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b6\u00102\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\"\u00108\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u0010\u0016\u001a\u0004\b9\u0010\u0003\"\u0004\b:\u0010\u0019R\"\u0010;\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010\u0016\u001a\u0004\b<\u0010\u0003\"\u0004\b=\u0010\u0019R\"\u0010?\u001a\u00020>8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010F\u001a\u0004\u0018\u00010E8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\"\u0010L\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bL\u0010\u0016\u001a\u0004\bM\u0010\u0003\"\u0004\bN\u0010\u0019R$\u0010P\u001a\u0004\u0018\u00010O8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010\r\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R\"\u0010`\u001a\u00020\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b`\u0010\u0016\u001a\u0004\ba\u0010\u0003\"\u0004\bb\u0010\u0019¨\u0006h"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig;", "", "toString", "()Ljava/lang/String;", "Landroid/content/Context;", "appContext", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "setAppContext", "(Landroid/content/Context;)V", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "I", "getAppId", "()I", "setAppId", "(I)V", "authType", "getAuthType", "setAuthType", "country", "Ljava/lang/String;", "getCountry", "setCountry", "(Ljava/lang/String;)V", "currencyType", "getCurrencyType", "setCurrencyType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "dataSender", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "getDataSender", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "setDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)V", "deviceId", "getDeviceId", "setDeviceId", "gslbAppId", "getGslbAppId", "setGslbAppId", "hostId", "getHostId", "setHostId", "httpUrl", "getHttpUrl", "setHttpUrl", "", "isOpenRisk", "Z", "()Z", "setOpenRisk", "(Z)V", "isTestEnv", "setTestEnv", "language", "getLanguage", "setLanguage", "packageName", "getPackageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "Ltv/athena/revenue/api/MiddleReportConfig;", "reportConfig", "Ltv/athena/revenue/api/MiddleReportConfig;", "getReportConfig", "()Ltv/athena/revenue/api/MiddleReportConfig;", "setReportConfig", "(Ltv/athena/revenue/api/MiddleReportConfig;)V", "token", "getToken", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "", "uid", "J", "getUid", "()J", "setUid", "(J)V", "useChannel", "getUseChannel", "setUseChannel", "version", WebChromeClient.MSG_METHOD_GETVERSION, "setVersion", "Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "builder", "<init>", "(Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;)V", "MiddleRevenueConfigBuilder", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes5.dex */
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
    public String httpUrl;
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
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b;\b\u0007\u0018\u0000B\u0007¢\u0006\u0004\bq\u0010rJ\r\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u000bJ\u0015\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0011J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u000e¢\u0006\u0004\b\u0017\u0010\u0011J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000e¢\u0006\u0004\b\u0019\u0010\u0011J\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u000e¢\u0006\u0004\b\u001f\u0010\u0011J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u0015\u0010%\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u000e¢\u0006\u0004\b%\u0010\u0011J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u000e¢\u0006\u0004\b'\u0010\u0011J\u0015\u0010*\u001a\u00020\u00002\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\u00002\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b.\u0010/J\u0015\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020 ¢\u0006\u0004\b1\u0010#J\u0015\u00103\u001a\u00020\u00002\u0006\u00102\u001a\u00020\u000e¢\u0006\u0004\b3\u0010\u0011J\u0017\u00106\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\u00020\u00002\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0015\u0010=\u001a\u00020\u00002\u0006\u0010<\u001a\u00020\b¢\u0006\u0004\b=\u0010\u000bJ\u0015\u0010?\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000e¢\u0006\u0004\b?\u0010\u0011R$\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010@\u001a\u0004\bA\u0010B\"\u0004\b\u0006\u0010CR\"\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010D\u001a\u0004\bE\u0010F\"\u0004\b\n\u0010GR\"\u0010\f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010D\u001a\u0004\bH\u0010F\"\u0004\b\r\u0010GR\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010I\u001a\u0004\bJ\u0010K\"\u0004\b\u0010\u0010LR\"\u0010\u0012\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010D\u001a\u0004\bM\u0010F\"\u0004\b\u0013\u0010GR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010\u0014\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010I\u001a\u0004\bS\u0010K\"\u0004\b\u0015\u0010LR\"\u0010T\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bT\u0010I\u001a\u0004\bU\u0010K\"\u0004\b\u0017\u0010LR\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010I\u001a\u0004\bV\u0010K\"\u0004\b\u0019\u0010LR\"\u0010\u001e\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010I\u001a\u0004\bW\u0010K\"\u0004\b\u001f\u0010LR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010X\u001a\u0004\b!\u0010Y\"\u0004\bZ\u0010[R\"\u00100\u001a\u00020 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b0\u0010X\u001a\u0004\b0\u0010Y\"\u0004\b1\u0010[R\"\u0010$\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010I\u001a\u0004\b\\\u0010K\"\u0004\b%\u0010LR\"\u0010&\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010I\u001a\u0004\b]\u0010K\"\u0004\b'\u0010LR\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010^\u001a\u0004\b_\u0010`\"\u0004\b*\u0010aR$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010b\u001a\u0004\bc\u0010d\"\u0004\b.\u0010eR\"\u00102\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010I\u001a\u0004\bf\u0010K\"\u0004\b3\u0010LR$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b5\u0010g\u001a\u0004\bh\u0010i\"\u0004\b6\u0010jR\"\u00109\u001a\u0002088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b9\u0010k\u001a\u0004\bl\u0010m\"\u0004\b:\u0010nR\"\u0010<\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010D\u001a\u0004\bo\u0010F\"\u0004\b=\u0010GR\"\u0010>\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010I\u001a\u0004\bp\u0010K\"\u0004\b?\u0010L¨\u0006s"}, d2 = {"Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleRevenueConfig;", "build", "()Ltv/athena/revenue/api/MiddleRevenueConfig;", "Landroid/content/Context;", "appContext", "setAppContext", "(Landroid/content/Context;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, "setAppId", "(I)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "authType", "setAuthType", "", "country", "setCountry", "(Ljava/lang/String;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "currencyType", "setCurrencyType", "deviceId", "setDeviceId", "gslpAppId", "setGslbAppId", "hostId", "setHostId", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "dataSender", "setHttpDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "httpUrl", "setHttpUrl", "", "isOpenRisk", "setIsOpenRisk", "(Z)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "language", "setLanguage", "packageName", "setPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "protoType", "setProtoType", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "Ltv/athena/revenue/api/MiddleReportConfig;", "reportConfig", "setReportConfig", "(Ltv/athena/revenue/api/MiddleReportConfig;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "isTestEnv", "setTestEnv", "token", "setToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "tokenCallback", "setTokenCallback", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "", "uid", "setUid", "(J)Ltv/athena/revenue/api/MiddleRevenueConfig$MiddleRevenueConfigBuilder;", "useChannel", "setUseChannel", "version", "setVersion", "Landroid/content/Context;", "getAppContext", "()Landroid/content/Context;", "(Landroid/content/Context;)V", "I", "getAppId", "()I", "(I)V", "getAuthType", "Ljava/lang/String;", "getCountry", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "getCurrencyType", "Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "getDataSender", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;", "setDataSender", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/data/IDataSenderAdapter;)V", "getDeviceId", "gslbAppId", "getGslbAppId", "getHostId", "getHttpUrl", "Z", "()Z", "setOpenRisk", "(Z)V", "getLanguage", "getPackageName", "Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "getProtoType", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/ProtocolType;)V", "Ltv/athena/revenue/api/MiddleReportConfig;", "getReportConfig", "()Ltv/athena/revenue/api/MiddleReportConfig;", "(Ltv/athena/revenue/api/MiddleReportConfig;)V", "getToken", "Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "getTokenCallback", "()Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/IToken;)V", "J", "getUid", "()J", "(J)V", "getUseChannel", WebChromeClient.MSG_METHOD_GETVERSION, "<init>", "()V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    /* loaded from: classes5.dex */
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
        public String httpUrl;
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
            this.httpUrl = "";
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

        public final String getHttpUrl() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.httpUrl : (String) invokeV.objValue;
        }

        public final String getLanguage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.language : (String) invokeV.objValue;
        }

        public final String getPackageName() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.packageName : (String) invokeV.objValue;
        }

        public final ProtocolType getProtoType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.protoType : (ProtocolType) invokeV.objValue;
        }

        public final MiddleReportConfig getReportConfig() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.reportConfig : (MiddleReportConfig) invokeV.objValue;
        }

        public final String getToken() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.token : (String) invokeV.objValue;
        }

        public final IToken getTokenCallback() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.tokenCallback : (IToken) invokeV.objValue;
        }

        public final long getUid() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.uid : invokeV.longValue;
        }

        public final int getUseChannel() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.useChannel : invokeV.intValue;
        }

        public final String getVersion() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.version : (String) invokeV.objValue;
        }

        public final boolean isOpenRisk() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.isOpenRisk : invokeV.booleanValue;
        }

        public final boolean isTestEnv() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.isTestEnv : invokeV.booleanValue;
        }

        /* renamed from: setAppContext  reason: collision with other method in class */
        public final void m2137setAppContext(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048599, this, context) == null) {
                this.appContext = context;
            }
        }

        /* renamed from: setAppId  reason: collision with other method in class */
        public final void m2138setAppId(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
                this.appId = i2;
            }
        }

        /* renamed from: setAuthType  reason: collision with other method in class */
        public final void m2139setAuthType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048603, this, i2) == null) {
                this.authType = i2;
            }
        }

        /* renamed from: setCountry  reason: collision with other method in class */
        public final void m2140setCountry(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
                this.country = str;
            }
        }

        /* renamed from: setCurrencyType  reason: collision with other method in class */
        public final void m2141setCurrencyType(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048607, this, i2) == null) {
                this.currencyType = i2;
            }
        }

        public final void setDataSender(IDataSenderAdapter iDataSenderAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048608, this, iDataSenderAdapter) == null) {
                this.dataSender = iDataSenderAdapter;
            }
        }

        /* renamed from: setDeviceId  reason: collision with other method in class */
        public final void m2142setDeviceId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
                this.deviceId = str;
            }
        }

        /* renamed from: setGslbAppId  reason: collision with other method in class */
        public final void m2143setGslbAppId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048612, this, str) == null) {
                this.gslbAppId = str;
            }
        }

        /* renamed from: setHostId  reason: collision with other method in class */
        public final void m2144setHostId(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
                this.hostId = str;
            }
        }

        public final MiddleRevenueConfigBuilder setHttpDataSender(IDataSenderAdapter iDataSenderAdapter) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, iDataSenderAdapter)) == null) {
                this.dataSender = iDataSenderAdapter;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        /* renamed from: setHttpUrl  reason: collision with other method in class */
        public final void m2145setHttpUrl(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
                this.httpUrl = str;
            }
        }

        public final MiddleRevenueConfigBuilder setIsOpenRisk(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048618, this, z)) == null) {
                this.isOpenRisk = z;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeZ.objValue;
        }

        /* renamed from: setLanguage  reason: collision with other method in class */
        public final void m2146setLanguage(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048620, this, str) == null) {
                this.language = str;
            }
        }

        public final void setOpenRisk(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
                this.isOpenRisk = z;
            }
        }

        /* renamed from: setPackageName  reason: collision with other method in class */
        public final void m2147setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048623, this, str) == null) {
                this.packageName = str;
            }
        }

        /* renamed from: setProtoType  reason: collision with other method in class */
        public final void m2148setProtoType(ProtocolType protocolType) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048625, this, protocolType) == null) {
                this.protoType = protocolType;
            }
        }

        /* renamed from: setReportConfig  reason: collision with other method in class */
        public final void m2149setReportConfig(MiddleReportConfig middleReportConfig) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048627, this, middleReportConfig) == null) {
                this.reportConfig = middleReportConfig;
            }
        }

        /* renamed from: setTestEnv  reason: collision with other method in class */
        public final void m2150setTestEnv(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048629, this, z) == null) {
                this.isTestEnv = z;
            }
        }

        /* renamed from: setToken  reason: collision with other method in class */
        public final void m2151setToken(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048631, this, str) == null) {
                this.token = str;
            }
        }

        /* renamed from: setTokenCallback  reason: collision with other method in class */
        public final void m2152setTokenCallback(IToken iToken) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048633, this, iToken) == null) {
                this.tokenCallback = iToken;
            }
        }

        /* renamed from: setUid  reason: collision with other method in class */
        public final void m2153setUid(long j2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048635, this, j2) == null) {
                this.uid = j2;
            }
        }

        /* renamed from: setUseChannel  reason: collision with other method in class */
        public final void m2154setUseChannel(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
                this.useChannel = i2;
            }
        }

        /* renamed from: setVersion  reason: collision with other method in class */
        public final void m2155setVersion(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048639, this, str) == null) {
                this.version = str;
            }
        }

        public final MiddleRevenueConfigBuilder setAppContext(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, context)) == null) {
                this.appContext = context;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setAppId(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
                this.appId = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setAuthType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048602, this, i2)) == null) {
                this.authType = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setCountry(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, str)) == null) {
                this.country = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setCurrencyType(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048606, this, i2)) == null) {
                this.currencyType = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setDeviceId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, str)) == null) {
                this.deviceId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setGslbAppId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
                this.gslbAppId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setHostId(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048613, this, str)) == null) {
                this.hostId = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setHttpUrl(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, str)) == null) {
                this.httpUrl = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setLanguage(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048619, this, str)) == null) {
                this.language = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setPackageName(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, str)) == null) {
                this.packageName = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setProtoType(ProtocolType protocolType) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, protocolType)) == null) {
                this.protoType = protocolType;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setReportConfig(MiddleReportConfig middleReportConfig) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, middleReportConfig)) == null) {
                this.reportConfig = middleReportConfig;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setTestEnv(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(1048628, this, z)) == null) {
                this.isTestEnv = z;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeZ.objValue;
        }

        public final MiddleRevenueConfigBuilder setToken(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048630, this, str)) == null) {
                this.token = str;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setTokenCallback(IToken iToken) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048632, this, iToken)) == null) {
                this.tokenCallback = iToken;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeL.objValue;
        }

        public final MiddleRevenueConfigBuilder setUid(long j2) {
            InterceptResult invokeJ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJ = interceptable.invokeJ(1048634, this, j2)) == null) {
                this.uid = j2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeJ.objValue;
        }

        public final MiddleRevenueConfigBuilder setUseChannel(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048636, this, i2)) == null) {
                this.useChannel = i2;
                return this;
            }
            return (MiddleRevenueConfigBuilder) invokeI.objValue;
        }

        public final MiddleRevenueConfigBuilder setVersion(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048638, this, str)) == null) {
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
        this.httpUrl = "";
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
        this.httpUrl = middleRevenueConfigBuilder.getHttpUrl();
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

    public final String getHttpUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.httpUrl : (String) invokeV.objValue;
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

    public final void setAppContext(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, context) == null) {
            this.appContext = context;
        }
    }

    public final void setAppId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.appId = i2;
        }
    }

    public final void setAuthType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048599, this, i2) == null) {
            this.authType = i2;
        }
    }

    public final void setCountry(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, str) == null) {
            this.country = str;
        }
    }

    public final void setCurrencyType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048601, this, i2) == null) {
            this.currencyType = i2;
        }
    }

    public final void setDataSender(IDataSenderAdapter iDataSenderAdapter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, iDataSenderAdapter) == null) {
            this.dataSender = iDataSenderAdapter;
        }
    }

    public final void setDeviceId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            this.deviceId = str;
        }
    }

    public final void setGslbAppId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, str) == null) {
            this.gslbAppId = str;
        }
    }

    public final void setHostId(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.hostId = str;
        }
    }

    public final void setHttpUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.httpUrl = str;
        }
    }

    public final void setLanguage(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.language = str;
        }
    }

    public final void setOpenRisk(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.isOpenRisk = z;
        }
    }

    public final void setPackageName(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, str) == null) {
            this.packageName = str;
        }
    }

    public final void setProtoType(ProtocolType protocolType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, protocolType) == null) {
            this.protoType = protocolType;
        }
    }

    public final void setReportConfig(MiddleReportConfig middleReportConfig) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, middleReportConfig) == null) {
            this.reportConfig = middleReportConfig;
        }
    }

    public final void setTestEnv(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.isTestEnv = z;
        }
    }

    public final void setToken(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.token = str;
        }
    }

    public final void setTokenCallback(IToken iToken) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, iToken) == null) {
            this.tokenCallback = iToken;
        }
    }

    public final void setUid(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048615, this, j2) == null) {
            this.uid = j2;
        }
    }

    public final void setUseChannel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            this.useChannel = i2;
        }
    }

    public final void setVersion(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048617, this, str) == null) {
            this.version = str;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return "MiddleRevenueConfig(appContext=" + this.appContext + ", appId=" + this.appId + ", useChannel=" + this.useChannel + StringUtil.ARRAY_ELEMENT_SEPARATOR + "currencyType=" + this.currencyType + ", packageName='" + this.packageName + "', version='" + this.version + "', language='" + this.language + "', country='" + this.country + "', isOpenRisk=" + this.isOpenRisk + ", authType=" + this.authType + ", reportConfig=" + this.reportConfig + StringUtil.ARRAY_ELEMENT_SEPARATOR + "isTestEnv=" + this.isTestEnv + ", dataSender=" + this.dataSender + ", protoType=" + this.protoType + StringUtil.ARRAY_ELEMENT_SEPARATOR + "tokenCallback=" + this.tokenCallback + ", hostId=" + this.hostId + ')';
        }
        return (String) invokeV.objValue;
    }

    public /* synthetic */ MiddleRevenueConfig(MiddleRevenueConfigBuilder middleRevenueConfigBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(middleRevenueConfigBuilder);
    }
}
