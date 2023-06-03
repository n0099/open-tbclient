package org.chromium.base.natives;

import T.N;
/* loaded from: classes2.dex */
public class GEN_JNI {
    public static final boolean REQUIRE_MOCK = false;
    public static final boolean TESTING_ENABLED = false;

    public static void com_baidu_turbonet_net_impl_CronetLibraryLoader_cronetInitOnInitThread() {
        N.MWrlQ89u();
    }

    public static String com_baidu_turbonet_net_impl_CronetLibraryLoader_getCronetVersion() {
        return N.MNED5yR1();
    }

    public static long com_baidu_turbonet_net_impl_CronetLibraryLoader_getTurboNetHandler() {
        return N.Ma3lrpiA();
    }

    public static String com_baidu_turbonet_net_impl_CronetLibraryLoader_getTurboNetVersion() {
        return N.M7l_b4ll();
    }

    public static byte[] com_baidu_turbonet_net_impl_CronetUrlRequestContext_getHistogramDeltas() {
        return N.MNpfFbsb();
    }

    public static String com_baidu_turbonet_net_impl_CronetUrlRequestContext_getTurboNetVersion() {
        return N.MLAkGrBe();
    }

    public static String[] org_chromium_base_CommandLine_getSwitchesFlattened() {
        return N.MHzche6O();
    }

    public static int org_chromium_base_CpuFeatures_getCoreCount() {
        return N.MOiBJ1qS();
    }

    public static long org_chromium_base_CpuFeatures_getCpuFeatures() {
        return N.ML0T8q1U();
    }

    public static boolean org_chromium_base_FeatureList_isInitialized() {
        return N.MFTJCvBh();
    }

    public static void org_chromium_base_FieldTrialList_logActiveTrials() {
        N.MHz6Fn06();
    }

    public static void org_chromium_base_PowerMonitor_onBatteryChargingChanged() {
        N.MCImhGql();
    }

    public static long org_chromium_base_TimeUtils_getTimeTicksNowUs() {
        return N.MklbOJun();
    }

    public static void org_chromium_base_TraceEvent_registerEnabledObserver() {
        N.MFFzPOVw();
    }

    public static void org_chromium_base_TraceEvent_stopATrace() {
        N.MOgCa3d$();
    }

    public static void org_chromium_net_X509Util_notifyKeyChainChanged() {
        N.MGVAvp19();
    }

    public static long com_baidu_turbonet_net_impl_CronetBidirectionalStream_createBidirectionalStream(Object obj, long j, boolean z, boolean z2, boolean z3, int i, boolean z4, int i2) {
        return N.M9zyjkwv(obj, j, z, z2, z3, i, z4, i2);
    }

    public static void org_chromium_base_task_PostTask_postDelayedTask(int i, boolean z, boolean z2, byte b, byte[] bArr, Object obj, long j, String str) {
        N.MTILOhAQ(i, z, z2, b, bArr, obj, j, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetBidirectionalStream_destroy(long j, Object obj, boolean z) {
        N.M7l4Nhk5(j, obj, z);
    }

    public static long com_baidu_turbonet_net_impl_CronetUploadDataStream_attachUploadDataToRequest(Object obj, long j, long j2) {
        return N.MUAXv489(obj, j, j2);
    }

    public static long com_baidu_turbonet_net_impl_CronetUploadDataStream_createUploadDataStreamForTesting(Object obj, long j, long j2) {
        return N.M_APU4Km(obj, j, j2);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_disableSpdyPingByHost(long j, Object obj, String str) {
        N.MNvSyo8Q(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_enableAddAltSvcByDefault(long j, Object obj, boolean z) {
        N.MqZaWjID(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_enableCustomProxy(long j, Object obj, boolean z) {
        N.M44YCLsv(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_enableMulConnect(long j, Object obj, boolean z) {
        N.M0ld2nar(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_forceDisableQuic(long j, Object obj, boolean z) {
        N.MTSN3dP5(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_getNetworkQualityStats(long j, Object obj, Object obj2) {
        N.MxXGCLhB(j, obj, obj2);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_onBdAppStatusChange(long j, Object obj, int i) {
        N.MOXbHinE(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_provideDataTrafficObservations(long j, Object obj, boolean z) {
        N.MaFfiiNl(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_provideNetworkQualityObservations(long j, Object obj, boolean z) {
        N.M0gd1dqN(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setAltQuicInterceptor(long j, Object obj, boolean z) {
        N.MWQSZZkY(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setAltQuicInterceptorWhitelist(long j, Object obj, String str) {
        N.M4_fbYNb(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setAntiAvalancheConf(long j, Object obj, int i) {
        N.MyEij$UO(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setAutoRecallConf(long j, Object obj, int i) {
        N.MpppV4kj(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setBdnsConnectTimeout(long j, Object obj, int i) {
        N.Mwv$$FON(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setBdnsRequestTimeout(long j, Object obj, int i) {
        N.M4BynuXH(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setDualStackBdnsCachePolicy(long j, Object obj, int i) {
        N.McarfCBi(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setDualStackBdnsServerIpPolicy(long j, Object obj, int i) {
        N.Mq3OwlDV(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setEdgeNodeChannelMode(long j, Object obj, int i) {
        N.MSZVYvpF(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setEdgeNodeHttpDetectIntervalMs(long j, Object obj, int i) {
        N.MZYQG2qE(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setEdgeNodeRulesByHost(long j, Object obj, String str) {
        N.MAumNPYz(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setFirstPacketTimeoutMs(long j, Object obj, int i) {
        N.MzQXOYYd(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setHandshakeTimeoutMs(long j, Object obj, int i) {
        N.MynHk7gj(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setReadPacketTimeoutMs(long j, Object obj, int i) {
        N.MTk6pmUN(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setRequestRulesByHost(long j, Object obj, String str) {
        N.MjWCV7vx(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setRequestRulesByUrl(long j, Object obj, String str) {
        N.MocO9faq(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setSendDelayTimeForQos(long j, Object obj, int i) {
        N.MRk8LVp2(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_uploadNetLog(long j, Object obj, String str) {
        N.M6sxZkzf(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_destroy(long j, Object obj, boolean z) {
        N.MaclenGB(j, obj, z);
    }

    public static String com_baidu_turbonet_net_impl_CronetUrlRequest_getConnectionAttempts(long j, Object obj, boolean z) {
        return N.MGyE3Fuw(j, obj, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_getStatus(long j, Object obj, Object obj2) {
        N.Mf5E3x0n(j, obj, obj2);
    }

    public static long com_baidu_turbonet_net_impl_CronetUrlRequest_requestTimeGap(long j, Object obj, int i) {
        return N.M940d5Ib(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_setCancelReason(long j, Object obj, int i) {
        N.MyCqIfwj(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_setDestinationAddress(long j, Object obj, String str) {
        N.Mf1wPgQz(j, obj, str);
    }

    public static boolean com_baidu_turbonet_net_impl_CronetUrlRequest_setHttpMethod(long j, Object obj, String str) {
        return N.MTRdjqfB(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_setRequestTag(long j, Object obj, String str) {
        N.MOCTFr9Z(j, obj, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_setResponseBodyReadTimeout(long j, Object obj, int i) {
        N.MQ$zOsz9(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_setResponseHeaderRecvTimeout(long j, Object obj, int i) {
        N.MN3tNP4d(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_setTCPConnectTimeout(long j, Object obj, int i) {
        N.MKbQWNzo(j, obj, i);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_setTimeout(long j, Object obj, int i) {
        N.MPLi1ygc(j, obj, i);
    }

    public static void org_chromium_base_EarlyTraceEvent_recordEarlyAsyncBeginEvent(String str, long j, long j2) {
        N.M_Gv8TwM(str, j, j2);
    }

    public static void org_chromium_base_EarlyTraceEvent_recordEarlyAsyncEndEvent(String str, long j, long j2) {
        N.MrKsqeCD(str, j, j2);
    }

    public static long org_chromium_base_metrics_NativeUmaRecorder_recordBooleanHistogram(String str, long j, boolean z) {
        return N.MtKTTHie(str, j, z);
    }

    public static long org_chromium_base_metrics_NativeUmaRecorder_recordSparseHistogram(String str, long j, int i) {
        return N.Mk1ai9mx(str, j, i);
    }

    public static void org_chromium_net_NetworkChangeNotifier_notifyMaxBandwidthChanged(long j, Object obj, int i) {
        N.Mt26m31j(j, obj, i);
    }

    public static void org_chromium_net_NetworkChangeNotifier_notifyOfNetworkDisconnect(long j, Object obj, long j2) {
        N.MDpuHJTB(j, obj, j2);
    }

    public static void org_chromium_net_NetworkChangeNotifier_notifyOfNetworkSoonToDisconnect(long j, Object obj, long j2) {
        N.MiJIMrTb(j, obj, j2);
    }

    public static void org_chromium_net_NetworkChangeNotifier_notifyPurgeActiveNetworkList(long j, Object obj, long[] jArr) {
        N.MpF$179U(j, obj, jArr);
    }

    public static boolean com_baidu_turbonet_net_impl_CronetBidirectionalStream_readData(long j, Object obj, Object obj2, int i, int i2) {
        return N.MoQQ01xr(j, obj, obj2, i, i2);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_enableSpdyPingByHost(long j, Object obj, String str, int i, int i2) {
        N.MlBgLkRx(j, obj, str, i, i2);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_preconnectURL(long j, Object obj, String str, int i, boolean z) {
        N.Mzpoz_bu(j, obj, str, i, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_resolveHost(long j, Object obj, Object obj2, String str, boolean z) {
        N.MsQ7vMjG(j, obj, obj2, str, z);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_setDataTrafficThreshold(long j, Object obj, int i, int i2, int i3) {
        N.Muhdm8n8(j, obj, i, i2, i3);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_startNetLogToDisk(long j, Object obj, String str, boolean z, int i) {
        N.MDG5pk4K(j, obj, str, z, i);
    }

    public static boolean com_baidu_turbonet_net_impl_CronetUrlRequest_readData(long j, Object obj, Object obj2, int i, int i2) {
        return N.M$wIxHTl(j, obj, obj2, i, i2);
    }

    public static void com_baidu_turbonet_net_impl_CronetBidirectionalStream_sendRequestHeaders(long j, Object obj) {
        N.MLzh0Fv2(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUploadDataStream_onRewindSucceeded(long j, Object obj) {
        N.MxRwumYi(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_applyBaiduConfigDictionary(long j, String str) {
        N.M9d07YFE(j, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_applyBaiduConfiguration(long j, String str) {
        N.MzeE_jt5(j, str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_destroy(long j, Object obj) {
        N.MquTH$m6(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_detectQuicConnectStatusByPreconnect(long j, Object obj) {
        N.MmRMeMcB(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_enableDataTrafficMonitor(long j, Object obj) {
        N.Mr0ED4xu(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_initRequestContextOnInitThread(long j, Object obj) {
        N.MksCwhuc(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_stopNetLog(long j, Object obj) {
        N.Mu$imfj5(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_disableResponseAutoUngzip(long j, Object obj) {
        N.MB2a2esR(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_followDeferredRedirect(long j, Object obj) {
        N.MBbNI3pk(j, obj);
    }

    public static String com_baidu_turbonet_net_impl_CronetUrlRequest_getDNSErrorCode(long j, Object obj) {
        return N.Mxpe7gzU(j, obj);
    }

    public static String com_baidu_turbonet_net_impl_CronetUrlRequest_getDNSNameServers(long j, Object obj) {
        return N.MA38JQKy(j, obj);
    }

    public static String com_baidu_turbonet_net_impl_CronetUrlRequest_getDNSResults(long j, Object obj) {
        return N.MGuRdhGv(j, obj);
    }

    public static String com_baidu_turbonet_net_impl_CronetUrlRequest_getRemoteEndpoint(long j, Object obj) {
        return N.MDBqRieE(j, obj);
    }

    public static Object com_baidu_turbonet_net_impl_CronetUrlRequest_getRequestTimeInfo(long j, Object obj) {
        return N.M0tS6tC4(j, obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequest_start(long j, Object obj) {
        N.MhRNx93s(j, obj);
    }

    public static int com_baidu_turbonet_net_impl_CronetUrlRequest_synGetStatus(long j, Object obj) {
        return N.MJiI6qKp(j, obj);
    }

    public static void org_chromium_base_CommandLine_appendSwitchWithValue(String str, String str2) {
        N.MUoYiNbY(str, str2);
    }

    public static boolean org_chromium_base_FieldTrialList_createFieldTrial(String str, String str2) {
        return N.MGqzwlIM(str, str2);
    }

    public static String org_chromium_base_FieldTrialList_getVariationParameter(String str, String str2) {
        return N.MZWMOP4I(str, str2);
    }

    public static boolean org_chromium_base_ImportantFileWriterAndroid_writeFileAtomically(String str, byte[] bArr) {
        return N.MsOKBrZ5(str, bArr);
    }

    public static void org_chromium_base_JavaExceptionReporter_reportJavaException(boolean z, Throwable th) {
        N.MLlibBXh(z, th);
    }

    public static void org_chromium_base_JavaHandlerThread_initializeThread(long j, long j2) {
        N.MJcct7gJ(j, j2);
    }

    public static void org_chromium_base_PathService_override(int i, String str) {
        N.M6H_IiaF(i, str);
    }

    public static void org_chromium_base_TraceEvent_begin(String str, String str2) {
        N.M9XfPu17(str, str2);
    }

    public static void org_chromium_base_TraceEvent_end(String str, String str2) {
        N.Mw73xTww(str, str2);
    }

    public static void org_chromium_base_TraceEvent_finishAsync(String str, long j) {
        N.MffNhCLU(str, j);
    }

    public static void org_chromium_base_TraceEvent_instant(String str, String str2) {
        N.ML40H8ed(str, str2);
    }

    public static void org_chromium_base_TraceEvent_startAsync(String str, long j) {
        N.MHopMqLX(str, j);
    }

    public static void org_chromium_base_metrics_NativeUmaRecorder_recordUserAction(String str, long j) {
        N.MTDsfZGe(str, j);
    }

    public static int org_chromium_base_metrics_RecordHistogram_getHistogramValueCountForTesting(String str, int i) {
        return N.M1gJHszj(str, i);
    }

    public static boolean org_chromium_net_HttpUtil_isAllowedHeader(String str, String str2) {
        return N.MorcXgQd(str, str2);
    }

    public static void org_chromium_net_NetworkActivationRequest_notifyAvailable(long j, long j2) {
        N.MJRUHS0T(j, j2);
    }

    public static void org_chromium_net_ProxyChangeListener_proxySettingsChanged(long j, Object obj) {
        N.MCIk73GZ(j, obj);
    }

    public static int com_baidu_turbonet_net_impl_CronetBidirectionalStream_start(long j, Object obj, String str, int i, String str2, String[] strArr, boolean z) {
        return N.MHm6x1d4(j, obj, str, i, str2, strArr, z);
    }

    public static boolean com_baidu_turbonet_net_impl_CronetBidirectionalStream_writevData(long j, Object obj, Object[] objArr, int[] iArr, int[] iArr2, boolean z) {
        return N.Mc3kG4ON(j, obj, objArr, iArr, iArr2, z);
    }

    public static long org_chromium_base_metrics_NativeUmaRecorder_recordExponentialHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return N.MILRV9Ch(str, j, i, i2, i3, i4);
    }

    public static long org_chromium_base_metrics_NativeUmaRecorder_recordLinearHistogram(String str, long j, int i, int i2, int i3, int i4) {
        return N.M$oMD214(str, j, i, i2, i3, i4);
    }

    public static long org_chromium_base_task_TaskRunnerImpl_init(int i, int i2, boolean z, boolean z2, byte b, byte[] bArr) {
        return N.M5_IQXaH(i, i2, z, z2, b, bArr);
    }

    public static void org_chromium_net_ProxyChangeListener_proxySettingsChangedTo(long j, Object obj, String str, int i, String str2, String[] strArr) {
        N.MyoFZt$2(j, obj, str, i, str2, strArr);
    }

    public static long com_baidu_turbonet_net_impl_CronetUploadDataStream_createAdapterForTesting(Object obj) {
        return N.M4q7TmV9(obj);
    }

    public static void com_baidu_turbonet_net_impl_CronetUploadDataStream_destroy(long j) {
        N.ME_EmysB(j);
    }

    public static long com_baidu_turbonet_net_impl_CronetUrlRequestContext_createRequestContextAdapter(long j) {
        return N.MErx$rwX(j);
    }

    public static int com_baidu_turbonet_net_impl_CronetUrlRequestContext_setMinLogLevel(int i) {
        return N.M5Tc4$Ht(i);
    }

    public static void org_chromium_base_ApplicationStatus_onApplicationStateChange(int i) {
        N.MiAkQ_SU(i);
    }

    public static void org_chromium_base_CommandLine_appendSwitch(String str) {
        N.M5K_ewhl(str);
    }

    public static void org_chromium_base_CommandLine_appendSwitchesAndArguments(String[] strArr) {
        N.MPquHBNa(strArr);
    }

    public static String org_chromium_base_CommandLine_getSwitchValue(String str) {
        return N.MZJ2lrZY(str);
    }

    public static boolean org_chromium_base_CommandLine_hasSwitch(String str) {
        return N.MsCvypjU(str);
    }

    public static void org_chromium_base_CommandLine_init(String[] strArr) {
        N.MDkrKi31(strArr);
    }

    public static void org_chromium_base_CommandLine_removeSwitch(String str) {
        N.M1cMYXGO(str);
    }

    public static String org_chromium_base_FieldTrialList_findFullName(String str) {
        return N.MdC43qwX(str);
    }

    public static boolean org_chromium_base_FieldTrialList_trialExists(String str) {
        return N.Mmqqda9c(str);
    }

    public static void org_chromium_base_JavaExceptionReporter_reportJavaStackTrace(String str) {
        N.MmS4zlEt(str);
    }

    public static void org_chromium_base_JavaHandlerThread_onLooperStopped(long j) {
        N.MYwg$x8E(j);
    }

    public static void org_chromium_base_MemoryPressureListener_onMemoryPressure(int i) {
        N.MZJzyjAa(i);
    }

    public static void org_chromium_base_TraceEvent_beginToplevel(String str) {
        N.M_y76mct(str);
    }

    public static void org_chromium_base_TraceEvent_endToplevel(String str) {
        N.MLJecZJ9(str);
    }

    public static void org_chromium_base_TraceEvent_setupATraceStartupTrace(String str) {
        N.MlFM5bdC(str);
    }

    public static void org_chromium_base_TraceEvent_startATrace(String str) {
        N.MRN$Vid3(str);
    }

    public static int org_chromium_base_metrics_RecordHistogram_getHistogramTotalCountForTesting(String str) {
        return N.M4mrObfZ(str);
    }

    public static long org_chromium_base_metrics_RecordUserAction_addActionCallbackForTesting(Object obj) {
        return N.MH0bOwlk(obj);
    }

    public static void org_chromium_base_metrics_RecordUserAction_removeActionCallbackForTesting(long j) {
        N.MJl0LdjQ(j);
    }

    public static String org_chromium_base_metrics_StatisticsRecorderAndroid_toJson(int i) {
        return N.MvO$oy3r(i);
    }

    public static boolean org_chromium_base_task_TaskRunnerImpl_belongsToCurrentThread(long j) {
        return N.MdFi6sVQ(j);
    }

    public static void org_chromium_base_task_TaskRunnerImpl_destroy(long j) {
        N.MERCiIV8(j);
    }

    public static String org_chromium_net_GURLUtils_getOrigin(String str) {
        return N.MpCt7siL(str);
    }

    public static String org_chromium_net_GURLUtils_getScheme(String str) {
        return N.M$mITdbo(str);
    }

    public static void com_baidu_turbonet_net_impl_CronetUploadDataStream_onReadSucceeded(long j, Object obj, int i, boolean z) {
        N.M_eREdDe(j, obj, i, z);
    }

    public static boolean com_baidu_turbonet_net_impl_CronetUrlRequestContext_startNetLogToFile(long j, Object obj, String str, boolean z) {
        return N.M5qRrqUf(j, obj, str, z);
    }

    public static boolean com_baidu_turbonet_net_impl_CronetUrlRequest_addRequestHeader(long j, Object obj, String str, String str2) {
        return N.MvH7FqGA(j, obj, str, str2);
    }

    public static void org_chromium_base_EarlyTraceEvent_recordEarlyBeginEvent(String str, long j, int i, long j2) {
        N.MrWG2uUW(str, j, i, j2);
    }

    public static void org_chromium_base_EarlyTraceEvent_recordEarlyEndEvent(String str, long j, int i, long j2) {
        N.MmyrhqXB(str, j, i, j2);
    }

    public static void org_chromium_base_EarlyTraceEvent_recordEarlyToplevelBeginEvent(String str, long j, int i, long j2) {
        N.M7UXCmoq(str, j, i, j2);
    }

    public static void org_chromium_base_EarlyTraceEvent_recordEarlyToplevelEndEvent(String str, long j, int i, long j2) {
        N.MRlw2LEn(str, j, i, j2);
    }

    public static void org_chromium_base_task_TaskRunnerImpl_postDelayedTask(long j, Object obj, long j2, String str) {
        N.MGnQU$47(j, obj, j2, str);
    }

    public static void org_chromium_net_HttpNegotiateAuthenticator_setResult(long j, Object obj, int i, String str) {
        N.M0s8NeYn(j, obj, i, str);
    }

    public static void org_chromium_net_NetworkChangeNotifier_notifyConnectionTypeChanged(long j, Object obj, int i, long j2) {
        N.MbPIImnU(j, obj, i, j2);
    }

    public static void org_chromium_net_NetworkChangeNotifier_notifyOfNetworkConnect(long j, Object obj, long j2, int i) {
        N.MBT1i5cd(j, obj, j2, i);
    }

    public static long com_baidu_turbonet_net_impl_CronetUrlRequestContext_createRequestContextConfig(String str, String str2, boolean z, String str3, boolean z2, boolean z3, boolean z4, int i, long j, String str4, long j2, boolean z5, boolean z6, int i2) {
        return N.MC$0lwZN(str, str2, z, str3, z2, z3, z4, i, j, str4, j2, z5, z6, i2);
    }

    public static void com_baidu_turbonet_net_impl_CronetUrlRequestContext_uploadNativeRequestLog(long j, Object obj, String str, String str2, int i, int i2, long j2, long j3, long j4, long j5) {
        N.MpIPpl2B(j, obj, str, str2, i, i2, j2, j3, j4, j5);
    }

    public static long com_baidu_turbonet_net_impl_CronetUrlRequest_createRequestAdapter(Object obj, long j, String str, int i, boolean z, boolean z2, boolean z3, boolean z4, int i2, boolean z5, int i3, int i4) {
        return N.MYqg_$OH(obj, j, str, i, z, z2, z3, z4, i2, z5, i3, i4);
    }
}
