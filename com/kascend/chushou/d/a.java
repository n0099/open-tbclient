package com.kascend.chushou.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.baidu.live.tbadk.log.LogConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.player.VideoPlayer;
import com.kascend.chushou.view.h5.H5Activity;
import com.kascend.chushou.view.h5.H5UploadActivity;
import com.kascend.chushou.view.user.RoomInfoActivity;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class a {
    public static void a(Context context, String str, String str2, String str3, String str4, JSONObject jSONObject) {
        boolean z;
        String str5;
        com.kascend.chushou.player.b dwT;
        boolean z2 = false;
        a(context);
        VideoPlayer videoPlayer = null;
        Activity a = f.a(context);
        if (a instanceof FragmentActivity) {
            videoPlayer = (FragmentActivity) a;
        }
        if (videoPlayer != null) {
            if (videoPlayer instanceof VideoPlayer) {
                z = true;
                VideoPlayer videoPlayer2 = videoPlayer;
                if (tv.chushou.zues.utils.h.isEmpty(str) && (dwT = videoPlayer2.dwT()) != null) {
                    str = dwT.a;
                }
                z2 = videoPlayer2.dxg();
                str5 = str;
            } else {
                z = false;
                str5 = str;
            }
            com.kascend.chushou.view.b.b.a.mDU.a(str2, str5, str3, z, z2).show(videoPlayer.getSupportFragmentManager(), "UserCardDialog");
        }
    }

    public static void a(Context context, JSONObject jSONObject, String str, String str2, String str3, boolean z) {
        boolean z2;
        boolean z3;
        String str4;
        com.kascend.chushou.player.b dwT;
        if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
            if (!tv.chushou.zues.utils.h.isEmpty(str3) && str3.equals(str2)) {
                z = false;
            }
            a(context);
            if (z) {
                ListItem listItem = new ListItem();
                listItem.mType = "5";
                listItem.mTargetKey = str2;
                e.a(context, listItem, jSONObject);
                return;
            }
            Activity a = f.a(context);
            VideoPlayer videoPlayer = a instanceof FragmentActivity ? (FragmentActivity) a : null;
            if (videoPlayer != null) {
                if (videoPlayer instanceof VideoPlayer) {
                    z3 = true;
                    VideoPlayer videoPlayer2 = videoPlayer;
                    if (tv.chushou.zues.utils.h.isEmpty(str) && (dwT = videoPlayer2.dwT()) != null) {
                        str = dwT.a;
                    }
                    z2 = videoPlayer2.dxg();
                    str4 = str;
                } else {
                    z2 = false;
                    z3 = false;
                    str4 = str;
                }
                com.kascend.chushou.view.b.b.a.mDU.a(str2, str4, null, z3, z2).show(videoPlayer.getSupportFragmentManager(), "UserCardDialog");
            }
        }
    }

    public static void a(Context context) {
        FragmentActivity fragmentActivity;
        FragmentManager supportFragmentManager;
        Fragment findFragmentByTag;
        if (!(context instanceof FragmentActivity)) {
            fragmentActivity = null;
        } else {
            fragmentActivity = (FragmentActivity) context;
        }
        if (fragmentActivity != null && (findFragmentByTag = (supportFragmentManager = fragmentActivity.getSupportFragmentManager()).findFragmentByTag("UserCardDialog")) != null && findFragmentByTag.isAdded()) {
            supportFragmentManager.beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
        }
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, RoomInfoActivity.class);
        intent.putExtra("type", 2);
        intent.putExtra(LogConfig.LOG_ROOMID, str);
        context.startActivity(intent);
    }

    public static void a(Context context, String str, String str2) {
        a(context, str, str2, false);
    }

    private static void a(Context context, String str, String str2, boolean z) {
        if (tv.chushou.zues.utils.h.isEmpty(str)) {
            tv.chushou.zues.utils.e.e("Activities", "url is empty!");
            return;
        }
        Intent intent = new Intent(context, H5Activity.class);
        Bundle bundle = new Bundle();
        bundle.putString("mH5Url", str);
        bundle.putString("mTitle", str2);
        bundle.putBoolean("mCanBack", true);
        bundle.putBoolean("mEnableRefresh", z);
        intent.putExtra("extra", bundle);
        if (f.a(context) == null) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        e.a(context, true);
    }

    public static void b(Context context, String str, String str2) {
        Intent intent = new Intent(context, H5UploadActivity.class);
        intent.putExtra("jsMethod", str);
        intent.putExtra("uploadParam", str2);
        context.startActivity(intent);
    }

    public static void b(Context context, String str) {
        com.kascend.cstvsdk.utils.a.mIX.a(context);
    }

    public static void c(Context context, String str) {
        com.kascend.cstvsdk.utils.a.mIX.c(context);
    }
}
