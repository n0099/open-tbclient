package com.example.image_loader_plugin;

import java.util.HashMap;
/* loaded from: classes6.dex */
public class ResNameTransform {
    private static HashMap<String, String> platformImageNameMap = new HashMap<>();
    private static HashMap<String, String> svgColorMap = new HashMap<>();

    static {
        platformImageNameMap.put("btn_sign_vip_n", "btn_vip_all_sign");
        platformImageNameMap.put("btn_sign_check_d", "bg_all_sign_conduct");
        platformImageNameMap.put("btn_sign_vip_h", "bg_vip_sign_ok_d");
        platformImageNameMap.put("btn_sign_check_n_v2", "btn_all_sign");
        platformImageNameMap.put("btn_sign_check_h", "bg_all_sign_ok_d");
        platformImageNameMap.put("assets/images/pic_use_header_80_n.webp", "pic_use_header_60_n");
        platformImageNameMap.put("assets/images/pic_use_header_80_n_1.webp", "pic_use_header_60_n");
        platformImageNameMap.put("assets/images/pic_use_header_80_n_2.webp", "pic_use_header_60_n");
        platformImageNameMap.put("assets/images/pic_use_header_70_n.webp", "pic_use_header_40_n");
        platformImageNameMap.put("assets/images/pic_use_header_70_n_1.webp", "pic_use_header_40_n");
        platformImageNameMap.put("assets/images/pic_use_header_70_n_2.webp", "pic_use_header_40_n");
        platformImageNameMap.put("icon_dredge_vip", "icon_btn_vip_sign");
        platformImageNameMap.put("icon_sign_gary_d", "icon_pure_topbar_sign44_svg");
        platformImageNameMap.put("icon_level_1", "icon_level_01");
        platformImageNameMap.put("icon_level_2", "icon_level_02");
        platformImageNameMap.put("icon_level_3", "icon_level_03");
        platformImageNameMap.put("icon_level_4", "icon_level_04");
        platformImageNameMap.put("icon_level_5", "icon_level_05");
        platformImageNameMap.put("icon_level_6", "icon_level_06");
        platformImageNameMap.put("icon_level_7", "icon_level_07");
        platformImageNameMap.put("icon_level_8", "icon_level_08");
        platformImageNameMap.put("icon_level_9", "icon_level_09");
        platformImageNameMap.put("icon_ba_about_ok", "icon_pop_pass");
        platformImageNameMap.put("icon_ba_about_add", "icon_brief_attention");
        platformImageNameMap.put("avatar_ba_defaul140", "icon_default_ba_120");
        platformImageNameMap.put("avatar_ba_defaul80", "pic_avatar_ba_140");
        platformImageNameMap.put("icon_arrow", "icon_frs_ba_arrows");
        platformImageNameMap.put("pic_emotion08", "new_pic_emotion_08");
        platformImageNameMap.put("icon_pure_topbar_scan44", "icon_pure_topbar_scan44_svg");
        platformImageNameMap.put("icon_pure_topbar_store44", "icon_pure_topbar_store44_svg");
        platformImageNameMap.put("icon_pure_topbar_set44", "icon_pure_topbar_set44_svg");
        platformImageNameMap.put("icon_crown_vip_non", "icon_crown_super_non");
        platformImageNameMap.put("icon_mask_boy_n", "icon_mask_boy16_svg");
        platformImageNameMap.put("icon_pure_list_arrow16_right", "icon_pure_list_arrow16_right_svg");
        platformImageNameMap.put("icon_personal_close_n", "icon_topbar_close_white_n");
        platformImageNameMap.put("icon_mask_wo_list_collect24", "icon_mask_wo_list_collect24_svg");
        platformImageNameMap.put("icon_mask_wo_list_history24", "icon_mask_wo_list_history24_svg");
        platformImageNameMap.put("icon_mask_wo_list_group24", "icon_mask_wo_list_group24_svg");
        platformImageNameMap.put("icon_mine_list_rich", "");
        platformImageNameMap.put("icon_mask_wo_list_youqianhua24", "icon_mask_wo_list_youqianhua24_svg");
        platformImageNameMap.put("icon_mask_wo_list_game24", "icon_mask_wo_list_game24_svg");
        platformImageNameMap.put("icon_mask_wo_list_duxiaoman24", "icon_mask_wo_list_duxiaoman24_svg");
        platformImageNameMap.put("icon_mask_wo_list_task24", "icon_mask_wo_list_task24_svg");
        platformImageNameMap.put("icon_mask_wo_list_sign24", "icon_mask_wo_list_sign24_svg");
        platformImageNameMap.put("icon_mask_wo_list_member24", "icon_mask_wo_list_member24_svg");
        platformImageNameMap.put("icon_mask_wo_list_gift24", "icon_mask_wo_list_gift24_svg");
        platformImageNameMap.put("icon_mask_wo_list_cardbag24", "icon_mask_wo_list_cardbag24_svg");
        platformImageNameMap.put("icon_mask_wo_list_diamond24", "icon_mask_wo_list_diamond24_svg");
        platformImageNameMap.put("icon_mask_wo_list_redenvelopes24", "icon_mask_wo_list_redenvelopes24_svg");
        platformImageNameMap.put("icon_mask_wo_list_live24", "icon_mask_wo_list_live24_svg");
        platformImageNameMap.put("icon_mask_wo_list_game24", "icon_mask_wo_list_game24_svg");
        platformImageNameMap.put("icon_mask_wo_list_topic24", "icon_mask_wo_list_topic24_svg");
        platformImageNameMap.put("icon_mask_wo_list_serve24", "icon_mask_wo_list_serve24_svg");
        platformImageNameMap.put("icon_mask_wo_list_exempt24", "icon_mask_wo_list_exempt24_svg");
        platformImageNameMap.put("icon_pure_wo_list_more24", "icon_pure_wo_list_more24_svg");
        svgColorMap.put("icon_pure_topbar_sign44_svg", "cp_cont_b");
        svgColorMap.put("icon_pure_topbar_scan44_svg", "cp_cont_b");
        svgColorMap.put("icon_pure_topbar_store44_svg", "cp_cont_b");
        svgColorMap.put("icon_pure_topbar_set44_svg", "cp_cont_b");
        svgColorMap.put("icon_pure_wo_list_more24_svg", "cp_cont_f");
        svgColorMap.put("icon_pure_list_arrow16_right_svg", "cp_cont_d");
    }

    public static String getAndroidNameFromIos(String str) {
        return platformImageNameMap.containsKey(str) ? platformImageNameMap.get(str) : str;
    }

    public static String getSvgColor(String str) {
        if (svgColorMap.containsKey(str)) {
            return svgColorMap.get(str);
        }
        return null;
    }
}
