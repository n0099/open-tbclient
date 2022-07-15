package com.repackage;

import com.baidu.searchbox.launch.SmartLaunchStats;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.EmotionDetailActivityConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.GraffitiInfo;
import tbclient.MemeInfo;
import tbclient.NativeApp;
import tbclient.PbContent;
import tbclient.PluginUser;
import tbclient.TiebaPlusInfo;
import tbclient.TogetherHi;
/* loaded from: classes6.dex */
public class pp4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ArrayList<PbContent> a(JSONArray jSONArray) throws JSONException {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jSONArray)) == null) {
            if (jSONArray != null) {
                ArrayList<PbContent> arrayList = new ArrayList<>();
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    PbContent.Builder builder = new PbContent.Builder();
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    builder.big_cdn_src = jSONObject.optString("big_cdn_src");
                    builder.big_size = jSONObject.optString("big_size");
                    builder.big_src = jSONObject.optString("big_src");
                    builder.bsize = jSONObject.optString("bsize");
                    builder.btn_type = Integer.valueOf(jSONObject.optInt("btn_type"));
                    builder.c = jSONObject.optString("c");
                    builder.cdn_src = jSONObject.optString("cdn_src");
                    builder.cdn_src_active = jSONObject.optString("cdn_src_active");
                    builder.count = Integer.valueOf(jSONObject.optInt("count"));
                    builder.during_time = Integer.valueOf(jSONObject.optInt("during_time"));
                    builder.dynamic = jSONObject.optString("dynamic");
                    builder.e_type = Integer.valueOf(jSONObject.optInt("e_type"));
                    JSONObject optJSONObject = jSONObject.optJSONObject("graffiti_info");
                    if (optJSONObject != null) {
                        GraffitiInfo.Builder builder2 = new GraffitiInfo.Builder();
                        builder2.gid = Long.valueOf(optJSONObject.optLong("gid"));
                        builder2.url = optJSONObject.optString("url");
                        builder.graffiti_info = builder2.build(true);
                    }
                    builder.height = Integer.valueOf(jSONObject.optInt(""));
                    JSONObject optJSONObject2 = jSONObject.optJSONObject("high_together");
                    if (optJSONObject2 != null) {
                        TogetherHi.Builder builder3 = new TogetherHi.Builder();
                        builder3.album_id = Long.valueOf(optJSONObject2.optLong("album_id"));
                        builder3.album_name = optJSONObject2.optString("album_name");
                        builder3.end_time = Integer.valueOf(optJSONObject2.optInt("end_time"));
                        builder3.location = optJSONObject2.optString("location");
                        builder3.num_join = Integer.valueOf(optJSONObject2.optInt("num_join"));
                        builder3.num_signup = Integer.valueOf(optJSONObject2.optInt("num_signup"));
                        JSONArray optJSONArray = optJSONObject2.optJSONArray("pic_urls");
                        if (optJSONArray != null) {
                            builder3.pic_urls = new ArrayList();
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                builder3.pic_urls.add(optJSONArray.optString(i2));
                            }
                        }
                        JSONArray optJSONArray2 = optJSONObject2.optJSONArray("potraits");
                        if (optJSONArray2 != null) {
                            builder3.potraits = new ArrayList();
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                builder3.potraits.add(optJSONArray2.optString(i3));
                            }
                        }
                        builder3.start_time = Integer.valueOf(optJSONObject2.optInt(SmartLaunchStats.UBC_BUSINESS_START_TIME_KEY));
                        builder.high_together = builder3.build(true);
                    }
                    builder.imgtype = jSONObject.optString("imgtype");
                    builder.is_long_pic = Integer.valueOf(jSONObject.optInt("is_long_pic"));
                    builder.is_native_app = Integer.valueOf(jSONObject.optInt("is_native_app"));
                    builder.is_sub = Integer.valueOf(jSONObject.optInt("is_sub"));
                    builder.link = jSONObject.optString("link");
                    builder.media_subtitle = jSONObject.optString("media_subtitle");
                    JSONObject optJSONObject3 = jSONObject.optJSONObject("meme_info");
                    if (optJSONObject3 != null) {
                        MemeInfo.Builder builder4 = new MemeInfo.Builder();
                        builder4.detail_link = optJSONObject3.optString("detail_link");
                        builder4.height = Integer.valueOf(optJSONObject3.optInt("height"));
                        builder4.pck_id = Integer.valueOf(optJSONObject3.optInt("pck_id"));
                        builder4.pic_id = Long.valueOf(optJSONObject3.optLong(EmotionDetailActivityConfig.EMOTION_PIC_ID_KEY));
                        builder4.pic_url = optJSONObject3.optString("pic_url");
                        builder4.thumbnail = optJSONObject3.optString("thumbnail");
                        builder4.width = Integer.valueOf(optJSONObject3.optInt("width"));
                        builder.meme_info = builder4.build(true);
                    }
                    JSONObject optJSONObject4 = jSONObject.optJSONObject("native_app");
                    if (optJSONObject4 != null) {
                        NativeApp.Builder builder5 = new NativeApp.Builder();
                        builder5.download_and = optJSONObject4.optString("download_and");
                        builder5.download_ios = optJSONObject4.optString("download_ios");
                        builder5.jump_and = optJSONObject4.optString("jump_and");
                        builder5.jump_ios = optJSONObject4.optString("jump_ios");
                        builder.native_app = builder5.build(true);
                    }
                    builder.origin_size = Integer.valueOf(jSONObject.optInt("origin_size"));
                    builder.origin_src = jSONObject.optString("origin_src");
                    builder.packet_name = jSONObject.optString("packet_name");
                    builder.phonetype = jSONObject.optString("phonetype");
                    builder.show_original_btn = Integer.valueOf(jSONObject.optInt("show_original_btn"));
                    builder.src = jSONObject.optString("src");
                    builder.text = jSONObject.optString("text");
                    builder.uid = Long.valueOf(jSONObject.optLong("uid"));
                    builder.type = Integer.valueOf(jSONObject.optInt("type"));
                    JSONObject optJSONObject5 = jSONObject.optJSONObject("tiebaplus_info");
                    if (optJSONObject5 != null) {
                        TiebaPlusInfo.Builder builder6 = new TiebaPlusInfo.Builder();
                        builder6.title = optJSONObject5.optString("title");
                        builder6.desc = optJSONObject5.optString("desc");
                        builder6.jump_url = optJSONObject5.optString(BigdayActivityConfig.JUMP_URL);
                        builder6.download_url = optJSONObject5.optString("download_url");
                        builder6.app_id = optJSONObject5.optString("app_id");
                        builder6.app_icon = optJSONObject5.optString("app_icon");
                        builder6.app_package = optJSONObject5.optString("app_package");
                        builder6.app_version = optJSONObject5.optString("app_version");
                        builder6.app_privacy = optJSONObject5.optString("app_privacy");
                        builder6.app_power = optJSONObject5.optString("app_power");
                        builder6.app_company = optJSONObject5.optString("app_company");
                        builder6.target_type = Integer.valueOf(optJSONObject5.optInt(GameGuideConfigInfo.KEY_TARGET_TYPE));
                        builder6.h5_jump_type = Integer.valueOf(optJSONObject5.optInt("h5_jump_type"));
                        builder6.h5_jump_number = optJSONObject5.optString("h5_jump_number");
                        builder6.h5_jump_param = optJSONObject5.optString("h5_jump_param");
                        builder6.jump_type = Integer.valueOf(optJSONObject5.optInt("jump_type"));
                        builder6.item_id = optJSONObject5.optString("item_id");
                        builder6.is_appoint = Integer.valueOf(optJSONObject5.optInt("is_appoint"));
                        JSONObject optJSONObject6 = optJSONObject5.optJSONObject("plugin_user");
                        if (optJSONObject6 != null) {
                            PluginUser.Builder builder7 = new PluginUser.Builder();
                            builder7.user_type = Integer.valueOf(optJSONObject6.optInt("user_type"));
                            builder7.user_id = Long.valueOf(optJSONObject6.optLong("user_id"));
                            builder7.user_name_show = optJSONObject6.optString("user_name_show");
                            builder7.user_photo = optJSONObject6.optString("user_photo");
                            builder6.plugin_user = builder7.build(true);
                        }
                        builder6.forum_name = optJSONObject5.optString("forum_name");
                        builder6.jump_setting = Integer.valueOf(optJSONObject5.optInt("jump_setting"));
                        builder6.wx_thumbnail = optJSONObject5.optString("wx_thumbnail");
                        builder6.button_desc = optJSONObject5.optString("button_desc");
                        builder.tiebaplus_info = builder6.build(true);
                    }
                    builder.url_type = Integer.valueOf(jSONObject.optInt("url_type"));
                    builder.voice_md5 = jSONObject.optString("voice_md5");
                    builder.width = Integer.valueOf(jSONObject.optInt("width"));
                    builder._static = jSONObject.optString("_static");
                    builder.item_id = Long.valueOf(jSONObject.optLong("item_id"));
                    builder.item_forum_name = jSONObject.optString("item_forum_name");
                    arrayList.add(builder.build(true));
                }
                return arrayList;
            }
            return null;
        }
        return (ArrayList) invokeL.objValue;
    }
}
