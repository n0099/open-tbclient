package com.ss.android.socialbase.downloader.b;

import android.text.TextUtils;
import com.baidu.live.tbadk.img.ImageUploadStrategy;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f13371a = "";

    /* renamed from: b  reason: collision with root package name */
    public static volatile String f13372b = "";
    public static volatile String c = "";
    public static long d = ImageUploadStrategy.FILE_SIZE_5M;
    public static long e = 31457280;
    public static long f = 10485760;
    public static final JSONObject g = new JSONObject();

    public static void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            f13371a = str;
        }
    }
}
