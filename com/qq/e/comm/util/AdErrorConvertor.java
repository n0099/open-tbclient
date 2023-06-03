package com.qq.e.comm.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class AdErrorConvertor {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public AdErrorConvertor() {
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

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:817)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:856)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:160)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:730)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public static com.qq.e.comm.util.AdError formatErrorCode(int r5) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.qq.e.comm.util.AdErrorConvertor.$ic
            if (r0 != 0) goto L2f4
        L4:
            r0 = 4014(0xfae, float:5.625E-42)
            if (r5 == r0) goto L2eb
            r0 = 4015(0xfaf, float:5.626E-42)
            if (r5 == r0) goto L2e3
            r0 = 5018(0x139a, float:7.032E-42)
            if (r5 == r0) goto L2db
            r0 = 5019(0x139b, float:7.033E-42)
            if (r5 == r0) goto L2d3
            r0 = 5021(0x139d, float:7.036E-42)
            if (r5 == r0) goto L2cb
            r0 = 5022(0x139e, float:7.037E-42)
            if (r5 == r0) goto L2c3
            r0 = 2002(0x7d2, float:2.805E-42)
            r1 = 2001(0x7d1, float:2.804E-42)
            switch(r5) {
                case 2001: goto L2bb;
                case 2002: goto L2b2;
                case 2003: goto L2a8;
                default: goto L23;
            }
        L23:
            switch(r5) {
                case 3001: goto L29e;
                case 3002: goto L294;
                case 3003: goto L28a;
                case 3004: goto L29e;
                case 3005: goto L29e;
                default: goto L26;
            }
        L26:
            r2 = 4001(0xfa1, float:5.607E-42)
            switch(r5) {
                case 4001: goto L281;
                case 4002: goto L276;
                case 4003: goto L26b;
                case 4004: goto L260;
                case 4005: goto L255;
                case 4006: goto L24a;
                case 4007: goto L23f;
                case 4008: goto L234;
                case 4009: goto L229;
                default: goto L2b;
            }
        L2b:
            r3 = 5009(0x1391, float:7.019E-42)
            r4 = 5005(0x138d, float:7.013E-42)
            switch(r5) {
                case 4011: goto L21e;
                case 4017: goto L213;
                case 5001: goto L208;
                case 5002: goto L1fd;
                case 5003: goto L1f2;
                case 5004: goto L1e7;
                case 5005: goto L1de;
                case 5006: goto L1d3;
                case 5007: goto L1c8;
                case 5008: goto L1bd;
                case 5009: goto L1b4;
                case 5010: goto L1a9;
                case 5011: goto L19e;
                case 5012: goto L193;
                case 5013: goto L188;
                case 5014: goto L17d;
                case 5024: goto L172;
                case 100133: goto L166;
                case 100159: goto L15b;
                case 102006: goto L14f;
                case 107009: goto L143;
                case 107011: goto L137;
                case 107030: goto L12b;
                case 107040: goto L11f;
                case 109502: goto L113;
                case 109506: goto L10a;
                case 109507: goto L101;
                case 109512: goto Lf5;
                case 132005: goto Le9;
                case 132007: goto Ldd;
                case 132008: goto Ld1;
                case 200101: goto Lc8;
                case 200102: goto Lbf;
                case 200103: goto Lb6;
                case 200201: goto Lad;
                case 200202: goto La4;
                case 400101: goto L8c;
                case 400102: goto L8c;
                case 400103: goto L8c;
                case 400104: goto L8c;
                default: goto L32;
            }
        L32:
            switch(r5) {
                case 100135: goto L80;
                case 100136: goto L74;
                default: goto L35;
            }
        L35:
            switch(r5) {
                case 107034: goto L1a9;
                case 107035: goto L69;
                default: goto L38;
            }
        L38:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            switch(r5) {
                case 107049: goto L5f;
                case 107050: goto L55;
                default: goto L3d;
            }
        L3d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "发生某些错误或问题，需要根据详细错误码来定位具体问题。详细码："
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r1 = 6000(0x1770, float:8.408E-42)
            r0.<init>(r1, r5)
            goto L2f3
        L55:
            r5 = 107050(0x1a22a, float:1.50009E-40)
            java.lang.String r1 = "SDK接口与广告位不匹配，广告位是模板2.0广告位，请调用SDK模板2.0接口请求广告。发生此问题时可至反馈中心提交工单(同时提供广告请求和回包数据)联系技术支持定位处理。"
            r0.<init>(r5, r1)
            goto L2f3
        L5f:
            r5 = 107049(0x1a229, float:1.50008E-40)
            java.lang.String r1 = "JS旧准入规则已废弃，目前不支持iOS设备以及微信环境，请使用符合准入规则的测试设备如安卓版手机QQ、QQ浏览器。"
            r0.<init>(r5, r1)
            goto L2f3
        L69:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4013(0xfad, float:5.623E-42)
            java.lang.String r1 = "在旧版SDK上使用了模板视频的广告位。请升级优量汇SDK版本至最新。"
            r0.<init>(r5, r1)
            goto L2f3
        L74:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 100136(0x18728, float:1.4032E-40)
            java.lang.String r1 = "广告位未匹配到合适规格和样式的素材资源，建议调整或扩充广告的样式，如需了解详情，请至反馈中心提单咨询。"
            r0.<init>(r5, r1)
            goto L2f3
        L80:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 100135(0x18727, float:1.40319E-40)
            java.lang.String r1 = "媒体未通过审核或广告位处于「封禁、暂停、冻结」等状态。建议检查媒体或广告位状态，如有疑问可联系运营人员或至反馈中心提单咨询。"
            r0.<init>(r5, r1)
            goto L2f3
        L8c:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "传入的参数有错误。详细码："
            r1.append(r3)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r2, r5)
            goto L2f3
        La4:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "内部错误，详细码：200202"
            r5.<init>(r0, r1)
            goto L2b9
        Lad:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "内部错误，详细码：200201"
            r5.<init>(r0, r1)
            goto L2b9
        Lb6:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "初始化错误，详细码：200103"
            r0.<init>(r1, r5)
            goto L2f3
        Lbf:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "初始化错误，详细码：200102"
            r0.<init>(r1, r5)
            goto L2f3
        Lc8:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "初始化错误，详细码：200101"
            r0.<init>(r1, r5)
            goto L2f3
        Ld1:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 132008(0x203a8, float:1.84983E-40)
            java.lang.String r1 = "server bidding请求广告时，token参数解析失败，请使用线上环境请求价格时返回的token参数而非联调工具中的token参数。"
            r0.<init>(r5, r1)
            goto L2f3
        Ldd:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 132007(0x203a7, float:1.84981E-40)
            java.lang.String r1 = "server bidding请求没有收到有效的广告素材，请检查实例化广告对象时使用的token是否过期（token有效期为90s）。"
            r0.<init>(r5, r1)
            goto L2f3
        Le9:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 132005(0x203a5, float:1.84978E-40)
            java.lang.String r1 = "server bidding请求广告时，缺少token参数。"
            r0.<init>(r5, r1)
            goto L2f3
        Lf5:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 109512(0x1abc8, float:1.53459E-40)
            java.lang.String r1 = "没有找到合适的素材类型或规格，例如非4G和WiFi网络，则无法返回视频广告。建议释放或调整广告位的素材要求。"
            r0.<init>(r5, r1)
            goto L2f3
        L101:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "广告请求量或者消耗等超过小时限额，请一小时后再请求广告。"
            r0.<init>(r3, r5)
            goto L2f3
        L10a:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "广告请求量或者消耗等超过日限额，请明天再请求广告。"
            r0.<init>(r4, r5)
            goto L2f3
        L113:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 109502(0x1abbe, float:1.53445E-40)
            java.lang.String r1 = "请求过于频繁或返回未曝光，且产生的收入低，触发平台出于成本考虑的填充限制。建议减少无效的重复请求，提升广告曝光率。"
            r0.<init>(r5, r1)
            goto L2f3
        L11f:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 107040(0x1a220, float:1.49995E-40)
            java.lang.String r1 = "错误的sdk接口调用，比如申请的广告位是原生自渲染，广告使用场景是信息流，却错误的调用了信息流的相关接口NativeExpressAD，就造成了广告位是自渲染，接口是模板渲染的不匹配情况。"
            r0.<init>(r5, r1)
            goto L2f3
        L12b:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 107030(0x1a216, float:1.49981E-40)
            java.lang.String r1 = "App包名无效,请参考app_bundle_id参数填写逻辑，请检查代码中使用的App包名是否和注册时填写的一致。"
            r0.<init>(r5, r1)
            goto L2f3
        L137:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 107011(0x1a203, float:1.49954E-40)
            java.lang.String r1 = "请求中的操作系统类型与广告位在优量汇平台的设置不匹配，请检查广告请求中的os字段是否正确。"
            r0.<init>(r5, r1)
            goto L2f3
        L143:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 107009(0x1a201, float:1.49952E-40)
            java.lang.String r1 = "JS请求域名不匹配，请检查JS请求域名是否正确，确保与在平台注册的域名一致。可先进行域名校验，成功后再进行广告请求。"
            r0.<init>(r5, r1)
            goto L2f3
        L14f:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 102006(0x18e76, float:1.42941E-40)
            java.lang.String r1 = "没有找到符合价格要求或体验要求的广告，也可能由于请求过于频繁或返回未曝光，且产生的收入低导致无广告返回。建议适当调整底价，并提升广告曝光率，或至平台广告中心检查核对屏蔽规则。"
            r0.<init>(r5, r1)
            goto L2f3
        L15b:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4016(0xfb0, float:5.628E-42)
            java.lang.String r1 = "应用横竖方向参数与广告位支持方向不匹配。"
            r0.<init>(r5, r1)
            goto L2f3
        L166:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 100133(0x18725, float:1.40316E-40)
            java.lang.String r1 = "请检查广告位ID的使用是否正确，并确保广告位处于开启状态（中途如有开关操作则需等待半小时后使用），如是新建广告位，请在新建30分钟后请求广告。"
            r0.<init>(r5, r1)
            goto L2f3
        L172:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5024(0x13a0, float:7.04E-42)
            java.lang.String r1 = "广告位接口组合错误，请检查代码中是否存在开屏非全屏广告使用全屏接口的情况。"
            r0.<init>(r5, r1)
            goto L2f3
        L17d:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5014(0x1396, float:7.026E-42)
            java.lang.String r1 = "广告被定向过滤（多发生在下载类广告，如应用安装或未安装），属于一种正常现象，开发者可酌情忽略，也可以通过调整一次广告请求返回的广告数量进行缓解。"
            r0.<init>(r5, r1)
            goto L2f3
        L188:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5013(0x1395, float:7.025E-42)
            java.lang.String r1 = "当前广告请求过于频繁，建议适当降低请求频率。"
            r0.<init>(r5, r1)
            goto L2f3
        L193:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5012(0x1394, float:7.023E-42)
            java.lang.String r1 = "广告已经过期，建议在调用show之前使用isValid方法判断下广告是否有效，广告有效再去拉取广告（如果开发者有使用预加载广告一定要先判断再展示）。"
            r0.<init>(r5, r1)
            goto L2f3
        L19e:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5011(0x1393, float:7.022E-42)
            java.lang.String r1 = "原生模板渲染失败。"
            r0.<init>(r5, r1)
            goto L2f3
        L1a9:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5010(0x1392, float:7.02E-42)
            java.lang.String r1 = "广告位与调用接口不匹配，导致广告样式校验失败，请检查是否存在广告形态与调用接口不一致的情况。比如，是否用插屏全屏广告位的实例化对象调用了插屏半屏接口loadAD()。"
            r0.<init>(r5, r1)
            goto L2f3
        L1b4:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "广告请求量或者消耗等超过小时限额，请下一小时再发起请求。"
            r0.<init>(r3, r5)
            goto L2f3
        L1bd:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5008(0x1390, float:7.018E-42)
            java.lang.String r1 = "调试期间使用连接代理或者网络不佳，导致图片加载错误，建议关闭代理或者确保网络状况良好再去请求广告，如仍有错误，请至反馈中心提单咨询。"
            r0.<init>(r5, r1)
            goto L2f3
        L1c8:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5007(0x138f, float:7.016E-42)
            java.lang.String r1 = "资源加载错误。"
            r0.<init>(r5, r1)
            goto L2f3
        L1d3:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5006(0x138e, float:7.015E-42)
            java.lang.String r1 = "包名校验错误，当前App的包名和优量汇移动联盟官网注册的媒体包名不一致，因此无广告返回"
            r0.<init>(r5, r1)
            goto L2f3
        L1de:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "广告请求量或消耗等指标超过日限额，请明日00:30后再发送请求。"
            r0.<init>(r4, r5)
            goto L2f3
        L1e7:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5004(0x138c, float:7.012E-42)
            java.lang.String r1 = "没有匹配到合适的广告资源，属于调试中或者线上广告的正常现象。如果您在调试环境中遇到此问题，可以通过帮助中的广告助手解决此类问题。"
            r0.<init>(r5, r1)
            goto L2f3
        L1f2:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5003(0x138b, float:7.01E-42)
            java.lang.String r1 = "视频素材播放错误。"
            r0.<init>(r5, r1)
            goto L2f3
        L1fd:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5002(0x138a, float:7.009E-42)
            java.lang.String r1 = "视频素材下载错误，如网络环境不佳导致视频类广告无法下载。建议检查网络环境后重试，如仍有错误，请联系优量汇运营人员或至反馈中心提单咨询。"
            r0.<init>(r5, r1)
            goto L2f3
        L208:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 5001(0x1389, float:7.008E-42)
            java.lang.String r1 = "后台数据异常，可能由于sdk版本过低导致。请升级优量汇SDK版本至最新，如仍有错误，请联系运营人员或至反馈中心提交工单联系技术支持处理。"
            r0.<init>(r5, r1)
            goto L2f3
        L213:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4017(0xfb1, float:5.629E-42)
            java.lang.String r1 = "广告实例尚未准备好。请确保在注册实例成功后再调用实例的相关方法。"
            r0.<init>(r5, r1)
            goto L2f3
        L21e:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4011(0xfab, float:5.62E-42)
            java.lang.String r1 = "由于网络环境不佳或连有连接代理，导致开屏广告拉取超过设置时间。请保障网络畅通，并根据错误信息提示修改嵌入代码；在开屏广告下，可以通过fetchDelay设置超时时间为5s或者其他时间。"
            r0.<init>(r5, r1)
            goto L2f3
        L229:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4009(0xfa9, float:5.618E-42)
            java.lang.String r1 = "开屏广告的自定义跳过按钮尺寸小于3x3dp。"
            r0.<init>(r5, r1)
            goto L2f3
        L234:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4008(0xfa8, float:5.616E-42)
            java.lang.String r1 = "设备方向不适合展示广告。"
            r0.<init>(r5, r1)
            goto L2f3
        L23f:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4007(0xfa7, float:5.615E-42)
            java.lang.String r1 = "当前广告形态不支持模拟器，或开屏不支持Pad，建议使用真机、手机进行测试，如在进行通路测试或者仍未解决，请至反馈中心提交工单联系技术支持处理。"
            r0.<init>(r5, r1)
            goto L2f3
        L24a:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4006(0xfa6, float:5.614E-42)
            java.lang.String r1 = "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口。"
            r0.<init>(r5, r1)
            goto L2f3
        L255:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4005(0xfa5, float:5.612E-42)
            java.lang.String r1 = "广告容器尺寸错误。"
            r0.<init>(r5, r1)
            goto L2f3
        L260:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4004(0xfa4, float:5.611E-42)
            java.lang.String r1 = "开屏场景的广告容器不可见，请将广告容器设置为可见，并及时移除上次拉取广告的view避免容器被遮挡；如是开屏全屏广告，请确保调用了fetchFullScreenAndShowIn接口。如果仍未解决，请至反馈中心提交工单联系技术支持处理。"
            r0.<init>(r5, r1)
            goto L2f3
        L26b:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4003(0xfa3, float:5.61E-42)
            java.lang.String r1 = "广告位错误。"
            r0.<init>(r5, r1)
            goto L2f3
        L276:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 4002(0xfa2, float:5.608E-42)
            java.lang.String r1 = "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予。"
            r0.<init>(r5, r1)
            goto L2f3
        L281:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "传入的参数有错误。"
            r0.<init>(r2, r5)
            goto L2f3
        L28a:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 3003(0xbbb, float:4.208E-42)
            java.lang.String r1 = "网络不可用。"
            r0.<init>(r5, r1)
            goto L2f3
        L294:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 3002(0xbba, float:4.207E-42)
            java.lang.String r1 = "网络超时。"
            r0.<init>(r5, r1)
            goto L2f3
        L29e:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 3001(0xbb9, float:4.205E-42)
            java.lang.String r1 = "网络问题导致，请开发者检查下是否有连接代理或者网络环境不佳，建议使用稳定的4G、5G网络或者WiFi，确认网络状态后重试。"
            r0.<init>(r5, r1)
            goto L2f3
        L2a8:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r5 = 2003(0x7d3, float:2.807E-42)
            java.lang.String r1 = "SDK未初始化。"
            r0.<init>(r5, r1)
            goto L2f3
        L2b2:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "内部错误。"
            r5.<init>(r0, r1)
        L2b9:
            r0 = r5
            goto L2f3
        L2bb:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r5 = "可能由于SDK版本较低，或系统应用不支持插件导致，可以将SDK升级至最新版本。如在进行通路测试或者仍未解决，请至反馈中心提交工单联系技术支持处理。"
            r0.<init>(r1, r5)
            goto L2f3
        L2c3:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "广告模板渲染失败。"
            r5.<init>(r0, r1)
            goto L2b9
        L2cb:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "该类型广告已废弃，请使用其他类型的广告。"
            r5.<init>(r0, r1)
            goto L2b9
        L2d3:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "appid被封，请至平台流量合作板块，检查appid的状态。"
            r5.<init>(r0, r1)
            goto L2b9
        L2db:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "当前请求所使用的广告位已被下线，请至开发者平台流量合作板块，检查广告位是否被关闭、冻结或者已被删除。"
            r5.<init>(r0, r1)
            goto L2b9
        L2e3:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "同一条广告不允许多次展示，请再次拉取后展示。"
            r5.<init>(r0, r1)
            goto L2b9
        L2eb:
            com.qq.e.comm.util.AdError r5 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "广告未成功返回或广告无效时，启动了广告展示，请在广告返回后再进行展示广告的操作。具体方法为，请在show之前，使用isValid判断广告是否有效，当结果为true时再去调用show方法。"
            r5.<init>(r0, r1)
            goto L2b9
        L2f3:
            return r0
        L2f4:
            r2 = r0
            r3 = 65537(0x10001, float:9.1837E-41)
            r4 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r2.invokeI(r3, r4, r5)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.qq.e.comm.util.AdError r1 = (com.qq.e.comm.util.AdError) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(int):com.qq.e.comm.util.AdError");
    }
}
