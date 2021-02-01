package com.yy.mediaframework.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class FileUtil {
    private static final String TAG = "FileUtil";

    public static String getFileFromSD(String str) {
        String str2 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str2 = str2 + readLine;
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        } catch (Exception e) {
            YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString());
        }
        return str2;
    }

    public static boolean createDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return true;
        }
        return file.mkdirs();
    }

    public static boolean isFileExist(String str) {
        return new File(str).exists();
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                YMFLog.error((Object) null, "[Util    ]", "exception:" + e.fillInStackTrace());
            }
        }
    }

    public static boolean checkEffectResIsExit(String str) {
        if (str != null) {
            String fileFromSD = getFileFromSD(str);
            String substring = str.substring(0, str.lastIndexOf("/") + 1);
            try {
                JSONObject jSONObject = new JSONObject(fileFromSD);
                JSONArray jSONArray = jSONObject.getJSONArray("filter_list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    String optString = jSONObject.getJSONArray("filter_list").optJSONObject(i).optString("type");
                    if (optString.equals("Face2dAnimationFilter")) {
                        JSONArray jSONArray2 = jSONArray.optJSONObject(i).optJSONObject("ext_data").getJSONArray("animationArr");
                        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                            JSONArray jSONArray3 = jSONArray2.optJSONObject(i2).getJSONArray("pngPathArr");
                            for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                String str2 = substring + jSONArray3.getString(i3);
                                if (!isFileExist(str2)) {
                                    YMFLog.error((Object) null, "[Util    ]", "file loss, pngFileName:" + str2);
                                    return false;
                                }
                            }
                        }
                        continue;
                    } else if (optString.equals("LookUpTableFilter")) {
                        String stringBuffer = new StringBuffer(substring).append(jSONArray.optJSONObject(i).optJSONObject("ext_data").optString("LUTPath")).toString();
                        if (!isFileExist(stringBuffer)) {
                            YMFLog.error((Object) null, "[Util    ]", "file loss, pngFileName:" + stringBuffer);
                            return false;
                        }
                    } else if (optString.equals("Face3dPlaneAnimationFilter")) {
                        JSONArray jSONArray4 = jSONArray.optJSONObject(i).optJSONObject("ext_data").getJSONArray("pngPathArr");
                        for (int i4 = 0; i4 < jSONArray4.length(); i4++) {
                            String str3 = substring + jSONArray4.getString(i4);
                            if (!isFileExist(str3)) {
                                YMFLog.error((Object) null, "[Util    ]", "file loss, pngFileName:" + str3);
                                return false;
                            }
                        }
                        continue;
                    } else if (optString.equals("BlendAnimationFilter")) {
                        JSONArray jSONArray5 = jSONArray.optJSONObject(i).optJSONObject("ext_data").getJSONArray("pngPathArr");
                        for (int i5 = 0; i5 < jSONArray5.length(); i5++) {
                            String str4 = substring + jSONArray5.getString(i5);
                            if (!isFileExist(str4)) {
                                YMFLog.error((Object) null, "[Util    ]", "file loss, pngFileName:" + str4);
                                return false;
                            }
                        }
                        continue;
                    } else if (optString.equals("BlendFilter")) {
                        String str5 = substring + jSONArray.optJSONObject(i).optJSONObject("ext_data").optString("blendImagePath");
                        if (!isFileExist(str5)) {
                            YMFLog.error((Object) null, "[Util    ]", "file loss, pngFileName:" + str5);
                            return false;
                        }
                    } else {
                        continue;
                    }
                }
            } catch (JSONException e) {
                YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString() + " , jsonFile:" + str);
                return false;
            }
        }
        return true;
    }

    public static HashMap<String, String> checkEffectConfig(String str, String str2) {
        JSONObject jSONObject;
        String str3;
        String str4;
        HashMap<String, String> hashMap = new HashMap<>();
        if (str2 != null) {
            try {
                JSONArray jSONArray = new JSONObject(getFileFromSD(str2)).getJSONArray("effectTypeList");
                if (jSONArray.length() == 1) {
                    str4 = str + "/" + jSONObject.getJSONArray("effectList").getString(0);
                    str3 = null;
                } else if (jSONArray.length() == 2) {
                    str3 = str + "/" + jSONObject.getJSONArray("effectList").getString(0);
                    str4 = str + "/" + jSONObject.getJSONArray("effectList").getString(1);
                } else {
                    str3 = null;
                    str4 = null;
                }
                hashMap.put("sticker", str4);
                hashMap.put("sticker_lut", str3);
                YMFLog.info(null, "[Util    ]", "stickEffect:" + str4 + " ,stickLutEffect:" + str3);
            } catch (JSONException e) {
                YMFLog.error((Object) null, "[Util    ]", "exception:" + e.toString() + " , jsonFile:" + str2);
            }
        }
        return hashMap;
    }

    public static void copyAssetFile(Context context, String str, String str2) {
        String str3 = str + "/" + str2;
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str3);
            if (!file2.exists()) {
                InputStream open = context.getAssets().open(str2);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = open.read(bArr);
                    if (read > 0) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.close();
                        open.close();
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
