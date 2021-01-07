package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.os.Process;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.io.File;
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f13830a = y.a(y.ay);

    /* renamed from: b  reason: collision with root package name */
    public static final String f13831b = y.a(y.az);
    public static boolean c = false;

    public static String a(Context context) {
        File dir = context.getDir(f13830a, 0);
        if (dir == null) {
            return "";
        }
        File file = new File(dir.getAbsolutePath() + File.separator + "1");
        return (file.exists() || file.mkdirs()) ? file.getAbsolutePath() + File.separator + f13831b : "";
    }

    public static void a(Context context, c cVar) {
        try {
            if (c) {
                return;
            }
            c = true;
            long c2 = cVar.c(context, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC);
            int myUid = Process.myUid();
            if (c2 == 0 || myUid == c2) {
                return;
            }
            cVar.a(context, "101", "", true);
            new File(a(context)).delete();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void b(Context context, c cVar) {
        long c2 = cVar.c(context, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC);
        int myUid = Process.myUid();
        int i = (c2 > 0L ? 1 : (c2 == 0L ? 0 : -1));
        if (i == 0) {
            cVar.e(context, 0L);
        } else if (i == 0 || myUid == c2) {
            cVar.e(context, 1L);
        } else {
            cVar.e(context, -1L);
        }
    }

    public static void c(Context context, c cVar) {
        long c2 = cVar.c(context, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC);
        long myUid = Process.myUid();
        if (c2 != myUid) {
            cVar.a(context, TbEnum.SystemMessage.EVENT_ID_PLUGIN_CONFIG_SYNC, "" + myUid, false);
        }
    }
}
