package d.a.l0.k;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<o> f51637a;

    static {
        SparseArray<o> sparseArray = new SparseArray<>();
        f51637a = sparseArray;
        sparseArray.put(5, new o(5, k.aiapp_menu_text_night_mode, h.aiapp_menu_item_nightmode, true));
        f51637a.put(35, new o(35, k.aiapp_menu_add_launcher, h.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        f51637a.put(39, new o(39, k.aiapp_menu_restart, h.aiapp_menu_item_restart_selector, true));
        f51637a.put(4, new o(4, k.aiapp_menu_text_share, h.aiapp_menu_item_share_arrow_selector, true));
        f51637a.put(37, new o(37, k.aiapp_menu_authority_management, h.aiapp_menu_item_ai_apps_authority_management_selector, true));
        f51637a.put(38, new o(38, k.aiapp_menu_text_favorite, h.aiapp_menu_item_add_fav_selector, true));
        f51637a.put(42, new o(42, k.aiapp_menu_game_restart, h.aiapp_menu_item_restart_selector, true));
        f51637a.put(49, new o(49, k.swan_app_menu_setting, h.swan_app_menu_item_setting_selector, true));
        f51637a.put(50, new o(50, k.swanapp_menu_font_setting, h.swan_app_menu_item_font_setting_selector, true));
        f51637a.put(43, new o(43, k.aiapp_menu_apply_guarantee, h.aiapp_menu_item_apply_guarantee_selector, true));
        f51637a.put(9, new o(9, k.aiapp_menu_text_feedback, h.aiapp_menu_item_feedback_selector, true));
        f51637a.put(46, new o(46, k.aiapp_menu_global_notice, h.aiapp_menu_item_global_notice_selector, true));
        f51637a.put(47, new o(47, k.aiapp_menu_global_private, h.aiapp_menu_item_global_private_selector, true));
    }

    public static o a(int i2) {
        return o.k(f51637a.get(i2));
    }

    public static List<o> b(int i2) {
        ArrayList arrayList = new ArrayList();
        if (i2 != 0) {
            if (i2 != 12) {
                if (i2 != 13) {
                    switch (i2) {
                        case 16:
                            arrayList.add(o.k(f51637a.get(5)));
                            break;
                        case 17:
                        case 18:
                            arrayList.add(o.k(f51637a.get(38)));
                            arrayList.add(o.k(f51637a.get(4)));
                            arrayList.add(o.k(f51637a.get(39)));
                            arrayList.add(o.k(f51637a.get(35)));
                            arrayList.add(o.k(f51637a.get(5)));
                            arrayList.add(o.k(f51637a.get(49)));
                            break;
                        case 19:
                            arrayList.add(o.l(f51637a.get(38), false));
                            arrayList.add(o.l(f51637a.get(4), false));
                            arrayList.add(o.k(f51637a.get(39)));
                            arrayList.add(o.l(f51637a.get(35), false));
                            arrayList.add(o.k(f51637a.get(5)));
                            arrayList.add(o.l(f51637a.get(49), false));
                            break;
                    }
                } else {
                    arrayList.add(o.k(f51637a.get(43)));
                }
            }
            arrayList.add(o.k(f51637a.get(38)));
            arrayList.add(o.k(f51637a.get(4)));
            arrayList.add(o.k(f51637a.get(39)));
            arrayList.add(o.k(f51637a.get(35)));
            arrayList.add(o.k(f51637a.get(5)));
            arrayList.add(o.k(f51637a.get(49)));
        } else {
            arrayList.add(o.k(f51637a.get(38)));
            arrayList.add(o.k(f51637a.get(5)));
            arrayList.add(o.k(f51637a.get(4)));
            arrayList.add(o.k(f51637a.get(35)));
            arrayList.add(o.k(f51637a.get(42)));
        }
        return arrayList;
    }
}
