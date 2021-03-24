package d.b.i0.p3.j.d;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import d.b.i0.p3.j.d.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f58964a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.p3.j.e.a f58965b;

    /* renamed from: c  reason: collision with root package name */
    public b f58966c;

    /* renamed from: d  reason: collision with root package name */
    public b.c f58967d;

    public a(Context context) {
        this.f58964a = context;
    }

    public static void a(List<d.b.i0.p3.j.e.a> list, int i, String str, String str2) {
        if (list == null) {
            return;
        }
        list.add(new d.b.i0.p3.j.e.a(str, i, str2));
    }

    public static List<d.b.i0.p3.j.e.a> c(Context context) {
        ArrayList arrayList = new ArrayList();
        if (context == null) {
            context = TbadkCoreApplication.getInst();
        }
        a(arrayList, R.drawable.filter_icon_avatar_default, context.getString(R.string.filter_nature), "origin");
        a(arrayList, R.drawable.filter_icon_avatar_hongkong, context.getString(R.string.filter_hongkong), "hongkong");
        a(arrayList, R.drawable.filter_icon_avatar_refreshing, context.getString(R.string.filter_refreshing), "refreshing");
        a(arrayList, R.drawable.filter_icon_avatar_girly, context.getString(R.string.filter_girly), "girly");
        a(arrayList, R.drawable.filter_icon_avatar_concrete, context.getString(R.string.filter_concrete), "concrete");
        a(arrayList, R.drawable.filter_icon_avatar_warm, context.getString(R.string.filter_warm), "warm");
        a(arrayList, R.drawable.filter_icon_avatar_cold, context.getString(R.string.filter_cold), "cold");
        a(arrayList, R.drawable.filter_icon_avatar_japanese, context.getString(R.string.filter_japanese), "Japanese");
        a(arrayList, R.drawable.filter_icon_avatar_cruz, context.getString(R.string.filter_hdr), "cruz");
        a(arrayList, R.drawable.filter_icon_avatar_abao, context.getString(R.string.filter_abao), "abao");
        a(arrayList, R.drawable.filter_icon_avatar_dew, context.getString(R.string.filter_dew), "dew");
        a(arrayList, R.drawable.filter_icon_avatar_slowlived, context.getString(R.string.filter_slowlived), "slowlived");
        a(arrayList, R.drawable.filter_icon_avatar_sweet, context.getString(R.string.filter_sweet), "sweet");
        a(arrayList, R.drawable.filter_icon_avatar_boardwalk, context.getString(R.string.filter_boardwalk), "boardwalk");
        a(arrayList, R.drawable.filter_icon_avatar_keylime, context.getString(R.string.filter_keylime), "keylime");
        a(arrayList, R.drawable.filter_icon_avatar_electric, context.getString(R.string.filter_electric), "electric");
        a(arrayList, R.drawable.filter_icon_avatar_silver, context.getString(R.string.filter_silver), "silver");
        a(arrayList, R.drawable.filter_icon_avatar_blackwhite, context.getString(R.string.filter_blackwhite), "blackwhite");
        return arrayList;
    }

    public static String d() {
        return d.b.i0.p3.c.f58889c + "video_addfilter_" + System.currentTimeMillis() + ".mp4";
    }

    public String b() {
        d.b.i0.p3.j.e.a aVar = this.f58965b;
        return (aVar == null || "normal".equalsIgnoreCase(aVar.f59004c)) ? "" : this.f58965b.f59004c;
    }

    public void e() {
        b bVar = this.f58966c;
        if (bVar != null) {
            bVar.e();
        }
    }

    public boolean f() {
        b bVar = this.f58966c;
        if (bVar != null) {
            return bVar.f();
        }
        return false;
    }

    public void g(String str, String str2) {
        b bVar = this.f58966c;
        if ((bVar == null || !bVar.f()) && !TextUtils.isEmpty(str) && new File(str).exists()) {
            b bVar2 = new b(this.f58964a, str, d(), str2);
            this.f58966c = bVar2;
            b.c cVar = this.f58967d;
            if (cVar != null) {
                bVar2.h(cVar);
            }
            this.f58966c.i();
        }
    }

    public void h(d.b.i0.p3.j.e.a aVar) {
        this.f58965b = aVar;
    }

    public void i(b.c cVar) {
        this.f58967d = cVar;
        b bVar = this.f58966c;
        if (bVar != null) {
            bVar.h(cVar);
        }
    }
}
