package d.n.a.a.a.a;

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
import com.yxcorp.kuaishou.addfp.a.b.j.g;
import d.n.a.a.c.b.f;
import java.util.concurrent.CountDownLatch;
/* loaded from: classes9.dex */
public final class c implements Runnable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public /* synthetic */ Context f72557e;

    /* renamed from: f  reason: collision with root package name */
    public /* synthetic */ a f72558f;

    /* renamed from: g  reason: collision with root package name */
    public /* synthetic */ b f72559g;

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
        this.f72559g = bVar;
        this.f72557e = context;
        this.f72558f = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:164:0x028c, code lost:
        if (((!android.os.Build.MANUFACTURER.equalsIgnoreCase("SSUI") && android.text.TextUtils.isEmpty(d.n.a.a.a.a.d.b("ro.ssui.product", ""))) ? false : false) == false) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b1 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01c0 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ec A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x01fb A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0227 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x023e A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0256 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0272 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02cf A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02d5 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0075 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b1 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bf A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d5 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df A[Catch: all -> 0x030d, TRY_LEAVE, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0117 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012f A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0145 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0154 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0180 A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x019b A[Catch: all -> 0x030d, TryCatch #0 {all -> 0x030d, blocks: (B:5:0x0020, B:7:0x0034, B:9:0x003a, B:11:0x0043, B:12:0x004d, B:14:0x005d, B:16:0x0065, B:22:0x0075, B:24:0x007d, B:31:0x008d, B:33:0x0095, B:35:0x009d, B:41:0x00b1, B:42:0x00ba, B:169:0x02c6, B:171:0x02cf, B:173:0x02d5, B:175:0x02e1, B:176:0x02ef, B:178:0x02fb, B:180:0x0301, B:43:0x00bf, B:45:0x00c7, B:51:0x00d5, B:52:0x00df, B:55:0x00e9, B:57:0x00f1, B:59:0x00fb, B:61:0x0105, B:67:0x0117, B:69:0x011f, B:76:0x012f, B:78:0x0137, B:84:0x0145, B:85:0x0154, B:87:0x015c, B:89:0x0164, B:91:0x016e, B:97:0x0180, B:98:0x019b, B:100:0x01a3, B:106:0x01b1, B:107:0x01c0, B:109:0x01c8, B:111:0x01d0, B:113:0x01da, B:119:0x01ec, B:120:0x01fb, B:122:0x0203, B:124:0x020b, B:126:0x0215, B:132:0x0227, B:134:0x022f, B:141:0x023e, B:143:0x0248, B:149:0x0256, B:157:0x0272, B:160:0x027e, B:152:0x0262, B:165:0x028e, B:166:0x029d, B:167:0x02ac, B:168:0x02b7), top: B:188:0x0020 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        b bVar;
        d.n.a.a.a.b.b dVar;
        d.n.a.a.a.b.b bVar2;
        d.n.a.a.a.b.b bVar3;
        d.n.a.a.a.b.b bVar4;
        d.n.a.a.a.b.b bVar5;
        d.n.a.a.a.b.b bVar6;
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
        d.n.a.a.a.b.b bVar7;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048576, this) != null) {
            return;
        }
        try {
            if (!this.f72557e.getPackageName().equals(f.a(Process.myPid()))) {
                d.n.a.a.c.b.c.b("call initOAID in diff proc");
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                this.f72559g.f72553b = new CountDownLatch(1);
            }
            this.f72559g.f72552a = this.f72558f;
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
                                            if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") && !Build.BRAND.equalsIgnoreCase("XIAOMI") && !Build.BRAND.equalsIgnoreCase("REDMI") && !Build.BRAND.equalsIgnoreCase("MEITU") && TextUtils.isEmpty(d.b("ro.miui.ui.version.name", ""))) {
                                                z5 = false;
                                                if (!z5) {
                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("BLACKSHARK") && !Build.BRAND.equalsIgnoreCase("BLACKSHARK")) {
                                                        z6 = false;
                                                        if (z6) {
                                                            if (!Build.MANUFACTURER.equalsIgnoreCase("SAMSUNG") && !Build.BRAND.equalsIgnoreCase("SAMSUNG")) {
                                                                z7 = false;
                                                                if (z7) {
                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("VIVO") && !Build.BRAND.equalsIgnoreCase("VIVO") && !Build.BRAND.equalsIgnoreCase("IQOO") && TextUtils.isEmpty(d.b("ro.vivo.os.version", ""))) {
                                                                        z8 = false;
                                                                        if (z8) {
                                                                            if (!Build.MANUFACTURER.equalsIgnoreCase("ASUS") && !Build.BRAND.equalsIgnoreCase("ASUS")) {
                                                                                z9 = false;
                                                                                if (z9) {
                                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI") && !Build.BRAND.equalsIgnoreCase("HUAWEI") && !Build.BRAND.equalsIgnoreCase("HONOR") && TextUtils.isEmpty(d.b("ro.build.version.emui", ""))) {
                                                                                        z10 = false;
                                                                                        if (z10) {
                                                                                            if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO") && !Build.BRAND.equalsIgnoreCase("OPPO") && !Build.BRAND.equalsIgnoreCase("REALME") && TextUtils.isEmpty(d.b("ro.build.version.opporom", ""))) {
                                                                                                z11 = false;
                                                                                                if (!z11) {
                                                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase(RomTypeUtil.ROM_ONEPLUS) && !Build.BRAND.equalsIgnoreCase(RomTypeUtil.ROM_ONEPLUS)) {
                                                                                                        z12 = false;
                                                                                                        if (z12) {
                                                                                                            if (!Build.MANUFACTURER.equalsIgnoreCase("ZTE") && !Build.BRAND.equalsIgnoreCase("ZTE")) {
                                                                                                                z13 = false;
                                                                                                                if (!z13) {
                                                                                                                    if (!Build.MANUFACTURER.equalsIgnoreCase("FREEMEOS") && TextUtils.isEmpty(d.b("ro.build.freeme.label", ""))) {
                                                                                                                        z14 = false;
                                                                                                                        if (!z14) {
                                                                                                                            boolean z15 = true;
                                                                                                                        }
                                                                                                                    }
                                                                                                                    z14 = true;
                                                                                                                    if (!z14) {
                                                                                                                    }
                                                                                                                }
                                                                                                                bVar = this.f72559g;
                                                                                                                dVar = new g(this.f72557e, b.c());
                                                                                                            }
                                                                                                            z13 = true;
                                                                                                            if (!z13) {
                                                                                                            }
                                                                                                            bVar = this.f72559g;
                                                                                                            dVar = new g(this.f72557e, b.c());
                                                                                                        }
                                                                                                    }
                                                                                                    z12 = true;
                                                                                                    if (z12) {
                                                                                                    }
                                                                                                }
                                                                                                bVar = this.f72559g;
                                                                                                dVar = new com.yxcorp.kuaishou.addfp.a.b.f.g(this.f72557e, b.c());
                                                                                            }
                                                                                            z11 = true;
                                                                                            if (!z11) {
                                                                                            }
                                                                                            bVar = this.f72559g;
                                                                                            dVar = new com.yxcorp.kuaishou.addfp.a.b.f.g(this.f72557e, b.c());
                                                                                        } else {
                                                                                            bVar = this.f72559g;
                                                                                            dVar = new com.yxcorp.kuaishou.addfp.a.b.b.c(this.f72557e, b.c());
                                                                                        }
                                                                                    }
                                                                                    z10 = true;
                                                                                    if (z10) {
                                                                                    }
                                                                                } else {
                                                                                    bVar = this.f72559g;
                                                                                    dVar = new com.yxcorp.kuaishou.addfp.a.b.a.a(this.f72557e, b.c());
                                                                                }
                                                                            }
                                                                            z9 = true;
                                                                            if (z9) {
                                                                            }
                                                                        } else {
                                                                            this.f72559g.f72554c = new d.n.a.a.a.b.i.b(this.f72557e);
                                                                            bVar7 = this.f72559g.f72554c;
                                                                            ((d.n.a.a.a.b.i.b) bVar7).b("100215079");
                                                                        }
                                                                        bVar2 = this.f72559g.f72554c;
                                                                        if (bVar2 != null) {
                                                                            this.f72559g.a(false, null);
                                                                            return;
                                                                        }
                                                                        bVar3 = this.f72559g.f72554c;
                                                                        if (!bVar3.a()) {
                                                                            bVar6 = this.f72559g.f72554c;
                                                                            bVar6.a(b.c());
                                                                            return;
                                                                        }
                                                                        bVar4 = this.f72559g.f72554c;
                                                                        if (!bVar4.c()) {
                                                                            this.f72559g.a(false, null);
                                                                            return;
                                                                        }
                                                                        b bVar8 = this.f72559g;
                                                                        bVar5 = this.f72559g.f72554c;
                                                                        bVar8.a(true, bVar5);
                                                                        return;
                                                                    }
                                                                    z8 = true;
                                                                    if (z8) {
                                                                    }
                                                                    bVar2 = this.f72559g.f72554c;
                                                                    if (bVar2 != null) {
                                                                    }
                                                                } else {
                                                                    bVar = this.f72559g;
                                                                    dVar = new com.yxcorp.kuaishou.addfp.a.b.g.g(this.f72557e, b.c());
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
                                                bVar = this.f72559g;
                                                dVar = new d.n.a.a.a.b.j.b(this.f72557e);
                                            }
                                            z5 = true;
                                            if (!z5) {
                                            }
                                            bVar = this.f72559g;
                                            dVar = new d.n.a.a.a.b.j.b(this.f72557e);
                                        } else {
                                            bVar = this.f72559g;
                                            dVar = new d.n.a.a.a.b.f.b(this.f72557e);
                                        }
                                    }
                                    z4 = true;
                                    if (z4) {
                                    }
                                } else {
                                    bVar = this.f72559g;
                                    dVar = new f(this.f72557e);
                                }
                                bVar.f72554c = dVar;
                                bVar2 = this.f72559g.f72554c;
                                if (bVar2 != null) {
                                }
                            }
                            z3 = true;
                            if (z3) {
                            }
                            bVar.f72554c = dVar;
                            bVar2 = this.f72559g.f72554c;
                            if (bVar2 != null) {
                            }
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
                bVar = this.f72559g;
                dVar = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.f72557e, b.c());
                bVar.f72554c = dVar;
                bVar2 = this.f72559g.f72554c;
                if (bVar2 != null) {
                }
            }
            z = true;
            if (!z) {
            }
            bVar = this.f72559g;
            dVar = new com.yxcorp.kuaishou.addfp.a.b.c.d(this.f72557e, b.c());
            bVar.f72554c = dVar;
            bVar2 = this.f72559g.f72554c;
            if (bVar2 != null) {
            }
        } catch (Throwable th) {
            d.n.a.a.c.b.c.c(th);
        }
    }
}
