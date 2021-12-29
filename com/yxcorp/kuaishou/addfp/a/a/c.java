package com.yxcorp.kuaishou.addfp.a.a;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.tbadk.core.util.RomTypeUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.un.g;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes4.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public /* synthetic */ Context a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ a f63873b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ b f63874c;

    public c(b bVar, Context context, a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, context, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f63874c = bVar;
        this.a = context;
        this.f63873b = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:163:0x0287, code lost:
        if (((!android.os.Build.MANUFACTURER.equalsIgnoreCase("SSUI") && android.text.TextUtils.isEmpty(com.yxcorp.kuaishou.addfp.a.a.d.a("ro.ssui.product", ""))) ? false : false) == false) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01ac A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01bb A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01e7 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01f6 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0222 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0239 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0251 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x026d A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02ca A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02d0 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0070 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0088 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ac A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ba A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d0 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00da A[Catch: all -> 0x0308, TRY_LEAVE, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0112 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012a A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0140 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x014f A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x017b A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0196 A[Catch: all -> 0x0308, TryCatch #0 {all -> 0x0308, blocks: (B:5:0x0020, B:8:0x0035, B:10:0x003e, B:11:0x0048, B:13:0x0058, B:15:0x0060, B:21:0x0070, B:23:0x0078, B:30:0x0088, B:32:0x0090, B:34:0x0098, B:40:0x00ac, B:41:0x00b5, B:168:0x02c1, B:170:0x02ca, B:172:0x02d0, B:174:0x02dc, B:175:0x02ea, B:177:0x02f6, B:179:0x02fc, B:42:0x00ba, B:44:0x00c2, B:50:0x00d0, B:51:0x00da, B:54:0x00e4, B:56:0x00ec, B:58:0x00f6, B:60:0x0100, B:66:0x0112, B:68:0x011a, B:75:0x012a, B:77:0x0132, B:83:0x0140, B:84:0x014f, B:86:0x0157, B:88:0x015f, B:90:0x0169, B:96:0x017b, B:97:0x0196, B:99:0x019e, B:105:0x01ac, B:106:0x01bb, B:108:0x01c3, B:110:0x01cb, B:112:0x01d5, B:118:0x01e7, B:119:0x01f6, B:121:0x01fe, B:123:0x0206, B:125:0x0210, B:131:0x0222, B:133:0x022a, B:140:0x0239, B:142:0x0243, B:148:0x0251, B:156:0x026d, B:159:0x0279, B:151:0x025d, B:164:0x0289, B:165:0x0298, B:166:0x02a7, B:167:0x02b2), top: B:187:0x0020 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        b bVar;
        com.yxcorp.kuaishou.addfp.a.b.a dVar;
        com.yxcorp.kuaishou.addfp.a.b.a aVar;
        com.yxcorp.kuaishou.addfp.a.b.a aVar2;
        com.yxcorp.kuaishou.addfp.a.b.a aVar3;
        com.yxcorp.kuaishou.addfp.a.b.a aVar4;
        com.yxcorp.kuaishou.addfp.a.b.a aVar5;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        com.yxcorp.kuaishou.addfp.a.b.a aVar6;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            if (!this.a.getPackageName().equals(com.yxcorp.kuaishou.addfp.android.b.e.a(Process.myPid()))) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f63874c.f63869d = new CountDownLatch(1);
            }
            this.f63874c.f63868b = this.f63873b;
            if (!Build.MANUFACTURER.equalsIgnoreCase("LENOVO") && !Build.BRAND.equalsIgnoreCase("LENOVO") && !Build.BRAND.equalsIgnoreCase("ZUK")) {
                z = false;
                if (!z) {
                    if (!Build.MANUFACTURER.equalsIgnoreCase("MOTOLORA") && !Build.BRAND.equalsIgnoreCase("MOTOLORA")) {
                        z2 = false;
                        if (z2) {
                            if (!Build.MANUFACTURER.equalsIgnoreCase("MEIZU") && !Build.BRAND.equalsIgnoreCase("MEIZU") && !Build.DISPLAY.toUpperCase().contains("FLYME")) {
                                z3 = false;
                                if (z3) {
                                    if (!Build.MANUFACTURER.equalsIgnoreCase(RomUtils.ROM_NUBIA) && !Build.BRAND.equalsIgnoreCase(RomUtils.ROM_NUBIA)) {
                                        z4 = false;
                                        if (z4) {
                                            if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") && !Build.BRAND.equalsIgnoreCase("XIAOMI") && !Build.BRAND.equalsIgnoreCase("REDMI") && !Build.BRAND.equalsIgnoreCase("MEITU") && TextUtils.isEmpty(d.a("ro.miui.ui.version.name", ""))) {
                                                z5 = false;
                                                if (!z5) {
                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") && !Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
                                                        z6 = false;
                                                        if (z6) {
                                                            if (!Build.MANUFACTURER.equalsIgnoreCase(g.f57226j) && !Build.BRAND.equalsIgnoreCase(g.f57226j)) {
                                                                z7 = false;
                                                                if (z7) {
                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("VIVO") && !Build.BRAND.equalsIgnoreCase("VIVO") && !Build.BRAND.equalsIgnoreCase("IQOO") && TextUtils.isEmpty(d.a("ro.vivo.os.version", ""))) {
                                                                        z8 = false;
                                                                        if (z8) {
                                                                            if (!Build.MANUFACTURER.equalsIgnoreCase("ASUS") && !Build.BRAND.equalsIgnoreCase("ASUS")) {
                                                                                z9 = false;
                                                                                if (z9) {
                                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") && !Build.BRAND.equalsIgnoreCase("HUAWEI") && !Build.BRAND.equalsIgnoreCase("HONOR") && TextUtils.isEmpty(d.a("ro.build.version.emui", ""))) {
                                                                                        z10 = false;
                                                                                        if (z10) {
                                                                                            if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO") && !Build.BRAND.equalsIgnoreCase("OPPO") && !Build.BRAND.equalsIgnoreCase("REALME") && TextUtils.isEmpty(d.a("ro.build.version.opporom", ""))) {
                                                                                                z11 = false;
                                                                                                if (!z11) {
                                                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase(RomTypeUtil.ROM_ONEPLUS) && !Build.BRAND.equalsIgnoreCase(RomTypeUtil.ROM_ONEPLUS)) {
                                                                                                        z12 = false;
                                                                                                        if (z12) {
                                                                                                            if (!Build.MANUFACTURER.equalsIgnoreCase("ZTE") && !Build.BRAND.equalsIgnoreCase("ZTE")) {
                                                                                                                z13 = false;
                                                                                                                if (!z13) {
                                                                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("FREEMEOS") && TextUtils.isEmpty(d.a("ro.build.freeme.label", ""))) {
                                                                                                                        z14 = false;
                                                                                                                        if (!z14) {
                                                                                                                            boolean z15 = true;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    z14 = true;
                                                                                                                    if (!z14) {
                                                                                                                    }
                                                                                                                }
                                                                                                                bVar = this.f63874c;
                                                                                                                dVar = new com.yxcorp.kuaishou.addfp.a.b.j.g(this.a, b.a());
                                                                                                            }
                                                                                                            z13 = true;
                                                                                                            if (!z13) {
                                                                                                            }
                                                                                                            bVar = this.f63874c;
                                                                                                            dVar = new com.yxcorp.kuaishou.addfp.a.b.j.g(this.a, b.a());
                                                                                                        }
                                                                                                    }
                                                                                                    z12 = true;
                                                                                                    if (z12) {
                                                                                                    }
                                                                                                }
                                                                                                bVar = this.f63874c;
                                                                                                dVar = new com.yxcorp.kuaishou.addfp.a.b.f.g(this.a, b.a());
                                                                                            }
                                                                                            z11 = true;
                                                                                            if (!z11) {
                                                                                            }
                                                                                            bVar = this.f63874c;
                                                                                            dVar = new com.yxcorp.kuaishou.addfp.a.b.f.g(this.a, b.a());
                                                                                        } else {
                                                                                            bVar = this.f63874c;
                                                                                            dVar = new com.yxcorp.kuaishou.addfp.a.b.b.c(this.a, b.a());
                                                                                        }
                                                                                    }
                                                                                    z10 = true;
                                                                                    if (z10) {
                                                                                    }
                                                                                } else {
                                                                                    bVar = this.f63874c;
                                                                                    dVar = new com.yxcorp.kuaishou.addfp.a.b.a.a(this.a, b.a());
                                                                                }
                                                                            }
                                                                            z9 = true;
                                                                            if (z9) {
                                                                            }
                                                                        } else {
                                                                            this.f63874c.f63870e = new com.yxcorp.kuaishou.addfp.a.b.h.b(this.a);
                                                                            aVar6 = this.f63874c.f63870e;
                                                                            ((com.yxcorp.kuaishou.addfp.a.b.h.b) aVar6).a("100215079");
                                                                        }
                                                                        aVar = this.f63874c.f63870e;
                                                                        if (aVar != null) {
                                                                            this.f63874c.a(false, (com.yxcorp.kuaishou.addfp.a.b.a) null);
                                                                            return;
                                                                        }
                                                                        aVar2 = this.f63874c.f63870e;
                                                                        if (!aVar2.a()) {
                                                                            aVar5 = this.f63874c.f63870e;
                                                                            aVar5.a(b.a());
                                                                            return;
                                                                        }
                                                                        aVar3 = this.f63874c.f63870e;
                                                                        if (!aVar3.c()) {
                                                                            this.f63874c.a(false, (com.yxcorp.kuaishou.addfp.a.b.a) null);
                                                                            return;
                                                                        }
                                                                        b bVar2 = this.f63874c;
                                                                        aVar4 = this.f63874c.f63870e;
                                                                        bVar2.a(true, aVar4);
                                                                        return;
                                                                    }
                                                                    z8 = true;
                                                                    if (z8) {
                                                                    }
                                                                    aVar = this.f63874c.f63870e;
                                                                    if (aVar != null) {
                                                                    }
                                                                } else {
                                                                    bVar = this.f63874c;
                                                                    dVar = new com.yxcorp.kuaishou.addfp.a.b.g.g(this.a, b.a());
                                                                }
                                                            }
                                                            z7 = true;
                                                            if (z7) {
                                                            }
                                                        }
                                                    }
                                                    z6 = true;
                                                    if (z6) {
                                                    }
                                                }
                                                bVar = this.f63874c;
                                                dVar = new com.yxcorp.kuaishou.addfp.a.b.i.b(this.a);
                                            }
                                            z5 = true;
                                            if (!z5) {
                                            }
                                            bVar = this.f63874c;
                                            dVar = new com.yxcorp.kuaishou.addfp.a.b.i.b(this.a);
                                        } else {
                                            bVar = this.f63874c;
                                            dVar = new com.yxcorp.kuaishou.addfp.a.b.e.b(this.a);
                                        }
                                    }
                                    z4 = true;
                                    if (z4) {
                                    }
                                } else {
                                    bVar = this.f63874c;
                                    dVar = new com.yxcorp.kuaishou.addfp.android.b.e(this.a);
                                }
                                bVar.f63870e = dVar;
                                aVar = this.f63874c.f63870e;
                                if (aVar != null) {
                                }
                            }
                            z3 = true;
                            if (z3) {
                            }
                            bVar.f63870e = dVar;
                            aVar = this.f63874c.f63870e;
                            if (aVar != null) {
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                bVar = this.f63874c;
                dVar = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.a, b.a());
                bVar.f63870e = dVar;
                aVar = this.f63874c.f63870e;
                if (aVar != null) {
                }
            }
            z = true;
            if (!z) {
            }
            bVar = this.f63874c;
            dVar = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.a, b.a());
            bVar.f63870e = dVar;
            aVar = this.f63874c.f63870e;
            if (aVar != null) {
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
