package com.qq.e.comm.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
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
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static com.qq.e.comm.util.AdError formatErrorCode(int r4) {
        /*
            com.baidu.titan.sdk.runtime.Interceptable r0 = com.qq.e.comm.util.AdErrorConvertor.$ic
            if (r0 != 0) goto L208
        L4:
            r0 = 700(0x2bc, float:9.81E-43)
            if (r4 == r0) goto L1fe
            r0 = 701(0x2bd, float:9.82E-43)
            if (r4 == r0) goto L1f4
            r0 = 4014(0xfae, float:5.625E-42)
            if (r4 == r0) goto L1ec
            r0 = 4015(0xfaf, float:5.626E-42)
            if (r4 == r0) goto L1e4
            r0 = 2001(0x7d1, float:2.804E-42)
            switch(r4) {
                case 300: goto L1db;
                case 301: goto L1d3;
                case 302: goto L1cb;
                case 303: goto L1c3;
                default: goto L19;
            }
        L19:
            r1 = 4001(0xfa1, float:5.607E-42)
            r2 = 2002(0x7d2, float:2.805E-42)
            switch(r4) {
                case 400: goto L1b9;
                case 800: goto L1af;
                case 4001: goto L1a7;
                case 4002: goto L19d;
                case 4003: goto L192;
                case 4004: goto L187;
                case 4005: goto L17c;
                case 4006: goto L171;
                case 4007: goto L166;
                case 4008: goto L15b;
                case 4009: goto L150;
                case 4011: goto L145;
                case 5001: goto L13a;
                case 5002: goto L1fe;
                case 5003: goto L1f4;
                case 5004: goto L12f;
                case 5005: goto L124;
                case 5006: goto L119;
                case 5007: goto L10e;
                case 5008: goto L103;
                case 5009: goto Lf8;
                case 5010: goto Led;
                case 5011: goto Le2;
                case 5012: goto Ld7;
                case 5013: goto Lcc;
                case 5021: goto Lc1;
                case 5022: goto Lb6;
                case 100159: goto Lab;
                case 107030: goto L119;
                case 107034: goto Led;
                case 107035: goto La0;
                case 109506: goto L124;
                case 109507: goto Lf8;
                case 200101: goto L1d3;
                case 200102: goto L1cb;
                case 200103: goto L1c3;
                case 200201: goto L97;
                case 200202: goto L8e;
                case 400101: goto L76;
                case 400102: goto L76;
                case 400103: goto L76;
                case 400104: goto L76;
                default: goto L20;
            }
        L20:
            switch(r4) {
                case 403: goto L1b9;
                case 404: goto L145;
                case 405: goto L10e;
                case 406: goto L103;
                default: goto L23;
            }
        L23:
            switch(r4) {
                case 500: goto L192;
                case 501: goto L12f;
                case 502: goto L13a;
                default: goto L26;
            }
        L26:
            switch(r4) {
                case 600: goto L187;
                case 601: goto L6b;
                case 602: goto L19d;
                case 603: goto L97;
                case 604: goto L8e;
                default: goto L29;
            }
        L29:
            switch(r4) {
                case 606: goto L17c;
                case 607: goto L171;
                case 608: goto L150;
                default: goto L2c;
            }
        L2c:
            switch(r4) {
                case 2001: goto L1db;
                case 2002: goto L62;
                case 2003: goto L57;
                default: goto L2f;
            }
        L2f:
            switch(r4) {
                case 3001: goto L1b9;
                case 3002: goto L4c;
                case 3003: goto L6b;
                case 3004: goto L1b9;
                case 3005: goto L1b9;
                default: goto L32;
            }
        L32:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "未知错误，详细码："
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r1 = 6000(0x1770, float:8.408E-42)
            r0.<init>(r1, r4)
            goto L207
        L4c:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 3002(0xbba, float:4.207E-42)
            java.lang.String r1 = "网络超时"
            r0.<init>(r4, r1)
            goto L207
        L57:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 2003(0x7d3, float:2.807E-42)
            java.lang.String r1 = "SDK未初始化"
            r0.<init>(r4, r1)
            goto L207
        L62:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "内部错误"
            r0.<init>(r2, r4)
            goto L207
        L6b:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 3003(0xbbb, float:4.208E-42)
            java.lang.String r1 = "网络不可用"
            r0.<init>(r4, r1)
            goto L207
        L76:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "传入的参数有错误，详细码："
            r2.append(r3)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            r0.<init>(r1, r4)
            goto L207
        L8e:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "内部错误，详细码：200202"
            r0.<init>(r2, r4)
            goto L207
        L97:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "内部错误，详细码：200201"
            r0.<init>(r2, r4)
            goto L207
        La0:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4013(0xfad, float:5.623E-42)
            java.lang.String r1 = "使用支持视频素材的原生模板广告位前，请升级您的SDK"
            r0.<init>(r4, r1)
            goto L207
        Lab:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4016(0xfb0, float:5.628E-42)
            java.lang.String r1 = "应用横竖方向参数与广告位支持方向不匹配"
            r0.<init>(r4, r1)
            goto L207
        Lb6:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5022(0x139e, float:7.037E-42)
            java.lang.String r1 = "广告模板渲染失败"
            r0.<init>(r4, r1)
            goto L207
        Lc1:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5021(0x139d, float:7.036E-42)
            java.lang.String r1 = "该类型广告已废弃，请使用其他类型的广告"
            r0.<init>(r4, r1)
            goto L207
        Lcc:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5013(0x1395, float:7.025E-42)
            java.lang.String r1 = "广告请求过于频繁，请稍后重试"
            r0.<init>(r4, r1)
            goto L207
        Ld7:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5012(0x1394, float:7.023E-42)
            java.lang.String r1 = "广告数据已过期，请重新拉取广告"
            r0.<init>(r4, r1)
            goto L207
        Le2:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5011(0x1393, float:7.022E-42)
            java.lang.String r1 = "原生模板渲染失败"
            r0.<init>(r4, r1)
            goto L207
        Led:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5010(0x1392, float:7.02E-42)
            java.lang.String r1 = "广告样式校验失败，请检查广告位与接口使用是否一致"
            r0.<init>(r4, r1)
            goto L207
        Lf8:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5009(0x1391, float:7.019E-42)
            java.lang.String r1 = "广告请求量或者消耗等超过小时限额，请一小时后再请求广告"
            r0.<init>(r4, r1)
            goto L207
        L103:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5008(0x1390, float:7.018E-42)
            java.lang.String r1 = "图片加载错误"
            r0.<init>(r4, r1)
            goto L207
        L10e:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5007(0x138f, float:7.016E-42)
            java.lang.String r1 = "资源加载错误"
            r0.<init>(r4, r1)
            goto L207
        L119:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5006(0x138e, float:7.015E-42)
            java.lang.String r1 = "包名校验错误，当前App的包名和优量汇移动联盟官网注册的媒体包名不一致，因此无广告返回"
            r0.<init>(r4, r1)
            goto L207
        L124:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5005(0x138d, float:7.013E-42)
            java.lang.String r1 = "广告请求量或者消耗等超过日限额，请明天再请求广告"
            r0.<init>(r4, r1)
            goto L207
        L12f:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5004(0x138c, float:7.012E-42)
            java.lang.String r1 = "没有广告"
            r0.<init>(r4, r1)
            goto L207
        L13a:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5001(0x1389, float:7.008E-42)
            java.lang.String r1 = "服务端数据错误"
            r0.<init>(r4, r1)
            goto L207
        L145:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4011(0xfab, float:5.62E-42)
            java.lang.String r1 = "开屏广告拉取超时"
            r0.<init>(r4, r1)
            goto L207
        L150:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4009(0xfa9, float:5.618E-42)
            java.lang.String r1 = "开屏广告的自定义跳过按钮尺寸小于3x3dp"
            r0.<init>(r4, r1)
            goto L207
        L15b:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4008(0xfa8, float:5.616E-42)
            java.lang.String r1 = "设备方向不适合展示广告"
            r0.<init>(r4, r1)
            goto L207
        L166:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4007(0xfa7, float:5.615E-42)
            java.lang.String r1 = "当前设备或系统不支持"
            r0.<init>(r4, r1)
            goto L207
        L171:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4006(0xfa6, float:5.614E-42)
            java.lang.String r1 = "原生广告接口调用顺序错误，调用点击接口前未调用曝光接口"
            r0.<init>(r4, r1)
            goto L207
        L17c:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4005(0xfa5, float:5.612E-42)
            java.lang.String r1 = "广告容器尺寸错误"
            r0.<init>(r4, r1)
            goto L207
        L187:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4004(0xfa4, float:5.611E-42)
            java.lang.String r1 = "开屏广告容器不可见"
            r0.<init>(r4, r1)
            goto L207
        L192:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4003(0xfa3, float:5.61E-42)
            java.lang.String r1 = "广告位错误"
            r0.<init>(r4, r1)
            goto L207
        L19d:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4002(0xfa2, float:5.608E-42)
            java.lang.String r1 = "Manifest文件中Activity/Service/Permission的声明有问题或者Permission权限未授予"
            r0.<init>(r4, r1)
            goto L207
        L1a7:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            java.lang.String r4 = "传入的参数有错误"
            r0.<init>(r1, r4)
            goto L207
        L1af:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 4012(0xfac, float:5.622E-42)
            java.lang.String r1 = "内容接口调用顺序错误，调用点击接口前未调用曝光接口"
            r0.<init>(r4, r1)
            goto L207
        L1b9:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 3001(0xbb9, float:4.205E-42)
            java.lang.String r1 = "网络异常"
            r0.<init>(r4, r1)
            goto L207
        L1c3:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误，详细码：200103"
            r4.<init>(r0, r1)
            goto L1e2
        L1cb:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误，详细码：200102"
            r4.<init>(r0, r1)
            goto L1e2
        L1d3:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误，详细码：200101"
            r4.<init>(r0, r1)
            goto L1e2
        L1db:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "初始化错误"
            r4.<init>(r0, r1)
        L1e2:
            r0 = r4
            goto L207
        L1e4:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "同一条广告不允许多次展示，请再次拉取后展示"
            r4.<init>(r0, r1)
            goto L1e2
        L1ec:
            com.qq.e.comm.util.AdError r4 = new com.qq.e.comm.util.AdError
            java.lang.String r1 = "广告数据尚未准备好"
            r4.<init>(r0, r1)
            goto L1e2
        L1f4:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5003(0x138b, float:7.01E-42)
            java.lang.String r1 = "视频素材播放错误"
            r0.<init>(r4, r1)
            goto L207
        L1fe:
            com.qq.e.comm.util.AdError r0 = new com.qq.e.comm.util.AdError
            r4 = 5002(0x138a, float:7.009E-42)
            java.lang.String r1 = "视频素材下载错误"
            r0.<init>(r4, r1)
        L207:
            return r0
        L208:
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
