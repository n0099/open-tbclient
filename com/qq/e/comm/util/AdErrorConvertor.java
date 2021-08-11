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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:155)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:94)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.qq.e.comm.util.AdError formatErrorCode(int r4) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.qq.e.comm.util.AdErrorConvertor.$ic
            if (r0 != 0) goto L202
        L4:
            r0 = 700(0x2bc, float:9.81E-43)
            if (r4 == r0) goto L1f8
            r0 = 701(0x2bd, float:9.82E-43)
            if (r4 == r0) goto L1ee
            r0 = 4014(0xfae, float:5.625E-42)
            if (r4 == r0) goto L1e6
            r0 = 4015(0xfaf, float:5.626E-42)
            if (r4 == r0) goto L1de
            r0 = 2001(0x7d1, float:2.804E-42)
            switch(r4) {
                case 300: goto L1d5;
                case 301: goto L1cd;
                case 302: goto L1c5;
                case 303: goto L1bd;
                default: goto L19;
            }
        L19:
            r1 = 4001(0xfa1, float:5.607E-42)
            r2 = 2002(0x7d2, float:2.805E-42)
            switch(r4) {
                case 400: goto L1b3;
                case 800: goto L1a9;
                case 4001: goto L1a1;
                case 4002: goto L197;
                case 4003: goto L18c;
                case 4004: goto L181;
                case 4005: goto L176;
                case 4006: goto L16b;
                case 4007: goto L160;
                case 4008: goto L155;
                case 4009: goto L14a;
                case 4011: goto L13f;
                case 5001: goto L134;
                case 5002: goto L1f8;
                case 5003: goto L1ee;
                case 5004: goto L129;
                case 5005: goto L11e;
                case 5006: goto L113;
                case 5007: goto L108;
                case 5008: goto Lfd;
                case 5009: goto Lf2;
                case 5010: goto Le7;
                case 5011: goto Ldc;
                case 5012: goto Ld1;
                case 5013: goto Lc6;
                case 5021: goto Lbb;
                case 5022: goto Lb0;
                case 100159: goto La5;
                case 107030: goto L113;
                case 107034: goto Le7;
                case 107035: goto L9a;
                case 109506: goto L11e;
                case 109507: goto Lf2;
                case 200101: goto L1cd;
                case 200102: goto L1c5;
                case 200103: goto L1bd;
                case 200201: goto L91;
                case 200202: goto L88;
                case 400101: goto L73;
                case 400102: goto L73;
                case 400103: goto L73;
                case 400104: goto L73;
                default: goto L20;
            }
        L20:
            switch(r4) {
                case 403: goto L1b3;
                case 404: goto L13f;
                case 405: goto L108;
                case 406: goto Lfd;
                default: goto L23;
            }
        L23:
            switch(r4) {
                case 500: goto L18c;
                case 501: goto L129;
                case 502: goto L134;
                default: goto L26;
            }
        L26:
            switch(r4) {
                case 600: goto L181;
                case 601: goto L68;
                case 602: goto L197;
                case 603: goto L91;
                case 604: goto L88;
                default: goto L29;
            }
        L29:
            switch(r4) {
                case 606: goto L176;
                case 607: goto L16b;
                case 608: goto L14a;
                default: goto L2c;
            }
        L2c:
            switch(r4) {
                case 2001: goto L1d5;
                case 2002: goto L5f;
                case 2003: goto L54;
                default: goto L2f;
            }
        L2f:
            switch(r4) {
                case 3001: goto L1b3;
                case 3002: goto L49;
                case 3003: goto L68;
                case 3004: goto L1b3;
                case 3005: goto L1b3;
                default: goto L32;
            }
        L32:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r1 = 6000(0x1770, float:8.408E-42)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "未知错误，详细码："
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r0.<init>(r1, r4)
            goto L201
        L49:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 3002(0xbba, float:4.207E-42)
            java.lang.String r1 = "网络超时"
            r0.<init>(r4, r1)
            goto L201
        L54:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 2003(0x7d3, float:2.807E-42)
            java.lang.String r1 = "SDK未初始化"
            r0.<init>(r4, r1)
            goto L201
        L5f:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "内部错误"
            r0.<init>(r2, r4)
            goto L201
        L68:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 3003(0xbbb, float:4.208E-42)
            java.lang.String r1 = "网络不可用"
            r0.<init>(r4, r1)
            goto L201
        L73:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "传入的参数有错误，详细码："
            r2.<init>(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r0.<init>(r1, r4)
            goto L201
        L88:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "内部错误，详细码：200202"
            r0.<init>(r2, r4)
            goto L201
        L91:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "内部错误，详细码：200201"
            r0.<init>(r2, r4)
            goto L201
        L9a:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4013(0xfad, float:5.623E-42)
            java.lang.String r1 = "使用支持视频素材的原生模板广告位前，请升级您的SDK"
            r0.<init>(r4, r1)
            goto L201
        La5:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4016(0xfb0, float:5.628E-42)
            java.lang.String r1 = "应用横竖方向参数与广告位支持方向不匹配"
            r0.<init>(r4, r1)
            goto L201
        Lb0:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5022(0x139e, float:7.037E-42)
            java.lang.String r1 = "广告模板渲染失败"
            r0.<init>(r4, r1)
            goto L201
        Lbb:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5021(0x139d, float:7.036E-42)
            java.lang.String r1 = "该类型广告已废弃，请使用其他类型的广告"
            r0.<init>(r4, r1)
            goto L201
        Lc6:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5013(0x1395, float:7.025E-42)
            java.lang.String r1 = "广告请求过于频繁，请稍后重试"
            r0.<init>(r4, r1)
            goto L201
        Ld1:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5012(0x1394, float:7.023E-42)
            java.lang.String r1 = "广告数据已过期，请重新拉取广告"
            r0.<init>(r4, r1)
            goto L201
        Ldc:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5011(0x1393, float:7.022E-42)
            java.lang.String r1 = "原生模板渲染失败"
            r0.<init>(r4, r1)
            goto L201
        Le7:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5010(0x1392, float:7.02E-42)
            java.lang.String r1 = "广告样式校验失败，请检查广告位与接口使用是否一致"
            r0.<init>(r4, r1)
            goto L201
        Lf2:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5009(0x1391, float:7.019E-42)
            java.lang.String r1 = "广告请求量或者消耗等超过小时限额，请一小时后再请求广告"
            r0.<init>(r4, r1)
            goto L201
        Lfd:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5008(0x1390, float:7.018E-42)
            java.lang.String r1 = "图片加载错误"
            r0.<init>(r4, r1)
            goto L201
        L108:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5007(0x138f, float:7.016E-42)
            java.lang.String r1 = "资源加载错误"
            r0.<init>(r4, r1)
            goto L201
        L113:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5006(0x138e, float:7.015E-42)
            java.lang.String r1 = "包名校验错误，当前App的包名和优量汇移动联盟官网注册的媒体包名不一致，因此无广告返回"
            r0.<init>(r4, r1)
            goto L201
        L11e:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5005(0x138d, float:7.013E-42)
            java.lang.String r1 = "广告请求量或者消耗等超过日限额，请明天再请求广告"
            r0.<init>(r4, r1)
            goto L201
        L129:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5004(0x138c, float:7.012E-42)
            java.lang.String r1 = "没有广告"
            r0.<init>(r4, r1)
            goto L201
        L134:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5001(0x1389, float:7.008E-42)
            java.lang.String r1 = "服务端数据错误"
            r0.<init>(r4, r1)
            goto L201
        L13f:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4011(0xfab, float:5.62E-42)
            java.lang.String r1 = "开屏广告拉取超时"
            r0.<init>(r4, r1)
            goto L201
        L14a:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4009(0xfa9, float:5.618E-42)
            java.lang.String r1 = "开屏广告的自定义跳过按钮尺寸小于3x3dp"
            r0.<init>(r4, r1)
            goto L201
        L155:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4008(0xfa8, float:5.616E-42)
            java.lang.String r1 = "设备方向不适合展示广告"
            r0.<init>(r4, r1)
            goto L201
        L160:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4007(0xfa7, float:5.615E-42)
            java.lang.String r1 = "当前设备或系统不支持"
            r0.<init>(r4, r1)
            goto L201
        L16b:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4006(0xfa6, float:5.614E-42)
            java.lang.String r1 = "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口"
            r0.<init>(r4, r1)
            goto L201
        L176:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4005(0xfa5, float:5.612E-42)
            java.lang.String r1 = "广告容器尺寸错误"
            r0.<init>(r4, r1)
            goto L201
        L181:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4004(0xfa4, float:5.611E-42)
            java.lang.String r1 = "开屏广告容器不可见"
            r0.<init>(r4, r1)
            goto L201
        L18c:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4003(0xfa3, float:5.61E-42)
            java.lang.String r1 = "广告位错误"
            r0.<init>(r4, r1)
            goto L201
        L197:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4002(0xfa2, float:5.608E-42)
            java.lang.String r1 = "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予"
            r0.<init>(r4, r1)
            goto L201
        L1a1:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "传入的参数有错误"
            r0.<init>(r1, r4)
            goto L201
        L1a9:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4012(0xfac, float:5.622E-42)
            java.lang.String r1 = "内容接口调用顺序错误，调用点击接口前未调用曝光接口"
            r0.<init>(r4, r1)
            goto L201
        L1b3:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 3001(0xbb9, float:4.205E-42)
            java.lang.String r1 = "网络异常"
            r0.<init>(r4, r1)
            goto L201
        L1bd:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误，详细码：200103"
            r4.<init>(r0, r1)
            goto L1dc
        L1c5:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误，详细码：200102"
            r4.<init>(r0, r1)
            goto L1dc
        L1cd:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误，详细码：200101"
            r4.<init>(r0, r1)
            goto L1dc
        L1d5:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误"
            r4.<init>(r0, r1)
        L1dc:
            r0 = r4
            goto L201
        L1de:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "同一条广告不允许多次展示，请再次拉取后展示"
            r4.<init>(r0, r1)
            goto L1dc
        L1e6:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "广告数据尚未准备好"
            r4.<init>(r0, r1)
            goto L1dc
        L1ee:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5003(0x138b, float:7.01E-42)
            java.lang.String r1 = "视频素材播放错误"
            r0.<init>(r4, r1)
            goto L201
        L1f8:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5002(0x138a, float:7.009E-42)
            java.lang.String r1 = "视频素材下载错误"
            r0.<init>(r4, r1)
        L201:
            return r0
        L202:
            r1 = r0
            r2 = 65537(0x10001, float:9.1837E-41)
            r3 = 0
            com.baidu.titan.sdk.runtime.InterceptResult r0 = r1.invokeI(r2, r3, r4)
            if (r0 == 0) goto L4
            java.lang.Object r1 = r0.objValue
            com.qq.e.comm.util.AdError r1 = (com.qq.e.comm.util.AdError) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.util.AdErrorConvertor.formatErrorCode(int):com.qq.e.comm.util.AdError");
    }
}
