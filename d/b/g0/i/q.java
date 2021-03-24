package d.b.g0.i;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public static SparseArray<o> f48872a;

    static {
        SparseArray<o> sparseArray = new SparseArray<>();
        f48872a = sparseArray;
        sparseArray.put(5, new o(5, k.aiapp_menu_text_night_mode, h.aiapp_menu_item_nightmode, true));
        f48872a.put(35, new o(35, k.aiapp_menu_add_launcher, h.aiapp_menu_item_ai_apps_add_to_launcher_selector, true));
        f48872a.put(39, new o(39, k.aiapp_menu_restart, h.aiapp_menu_item_restart_selector, true));
        f48872a.put(4, new o(4, k.aiapp_menu_text_share, h.aiapp_menu_item_share_arrow_selector, true));
        f48872a.put(37, new o(37, k.aiapp_menu_authority_management, h.aiapp_menu_item_ai_apps_authority_management_selector, true));
        f48872a.put(38, new o(38, k.aiapp_menu_text_favorite, h.aiapp_menu_item_add_fav_selector, true));
        f48872a.put(42, new o(42, k.aiapp_menu_game_restart, h.aiapp_menu_item_restart_selector, true));
        f48872a.put(49, new o(49, k.swan_app_menu_setting, h.swan_app_menu_item_setting_selector, true));
        f48872a.put(50, new o(50, k.swanapp_menu_font_setting, h.swan_app_menu_item_font_setting_selector, true));
    }

    public static o a(int i) {
        return o.l(f48872a.get(i));
    }

    public static List<o> b(int i) {
        ArrayList arrayList = new ArrayList();
        if (i != 0) {
            if (i != 12) {
                if (i != 13) {
                    switch (i) {
                        case 16:
                            arrayList.add(o.l(f48872a.get(5)));
                            break;
                        case 17:
                        case 18:
                            arrayList.add(o.l(f48872a.get(38)));
                            arrayList.add(o.l(f48872a.get(4)));
                            arrayList.add(o.l(f48872a.get(39)));
                            arrayList.add(o.l(f48872a.get(35)));
                            arrayList.add(o.l(f48872a.get(5)));
                            arrayList.add(o.l(f48872a.get(49)));
                            arrayList.add(o.l(f48872a.get(50)));
                            break;
                    }
                } else {
                    arrayList.add(o.l(f48872a.get(35)));
                    arrayList.add(o.l(f48872a.get(37)));
                }
            }
            arrayList.add(o.l(f48872a.get(38)));
            arrayList.add(o.l(f48872a.get(4)));
            arrayList.add(o.l(f48872a.get(39)));
            arrayList.add(o.l(f48872a.get(35)));
            arrayList.add(o.l(f48872a.get(5)));
            arrayList.add(o.l(f48872a.get(49)));
            arrayList.add(o.l(f48872a.get(50)));
        } else {
            arrayList.add(o.l(f48872a.get(38)));
            arrayList.add(o.l(f48872a.get(5)));
            arrayList.add(o.l(f48872a.get(4)));
            arrayList.add(o.l(f48872a.get(35)));
            arrayList.add(o.l(f48872a.get(42)));
        }
        return arrayList;
    }
}
