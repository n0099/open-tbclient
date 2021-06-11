package d.a.n0.f1.y;

import android.text.TextUtils;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.data.ShareFromPBMsgData;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    public int f58492a;

    /* renamed from: b  reason: collision with root package name */
    public T f58493b;

    public T a() {
        return this.f58493b;
    }

    public int b() {
        return this.f58492a;
    }

    /* JADX WARN: Type inference failed for: r1v7, types: [com.baidu.tbadk.data.ShareFromFrsMsgData, T] */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.baidu.tbadk.data.ShareFromGameCenterMsgData, T, com.baidu.tbadk.data.ShareFromPBMsgData] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.baidu.tbadk.data.ShareFromPBMsgData] */
    public int c(String str, String str2) {
        if (str == null) {
            return -1;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() == 3) {
                jSONArray.optString(0);
                this.f58492a = jSONArray.optInt(1);
                JSONObject optJSONObject = jSONArray.optJSONObject(2);
                if (1 == this.f58492a) {
                    String optString = optJSONObject.optString("button");
                    String optString2 = optJSONObject.optString("shareSourceIcon");
                    String optString3 = optJSONObject.optString("shareSource");
                    String optString4 = optJSONObject.optString("shareUrl");
                    String optString5 = optJSONObject.optString("shareSourceUrl");
                    if (TextUtils.isEmpty(optString4)) {
                        ?? r4 = (T) new ShareFromPBMsgData();
                        r4.setContent(optJSONObject.optString("themeContent"));
                        r4.setForumName(optJSONObject.optString("forumName"));
                        r4.setImageUrl(optJSONObject.optString("themeImageUrl"));
                        r4.setPostId(optJSONObject.optString("postID"));
                        r4.setThreadId(optJSONObject.optString("themeID"));
                        r4.setTitle(optJSONObject.optString("themeTitle"));
                        r4.setTheNewThemeId(optJSONObject.optString("theNewThemeID"));
                        r4.setThreadType(optJSONObject.optInt("threadType"));
                        this.f58493b = r4;
                        return 0;
                    }
                    ?? r1 = (T) new ShareFromGameCenterMsgData();
                    r1.setContent(optJSONObject.optString("themeContent"));
                    r1.setForumName(optJSONObject.optString("forumName"));
                    r1.setImageUrl(optJSONObject.optString("themeImageUrl"));
                    r1.setPostId(optJSONObject.optString("postID"));
                    r1.setThreadId(optJSONObject.optString("themeID"));
                    r1.setTitle(optJSONObject.optString("themeTitle"));
                    r1.setButton(optString);
                    r1.setShareSource(optString3);
                    r1.setShareSourceIcon(optString2);
                    r1.setShareSourceUrl(optString5);
                    r1.setShareUrl(optString4);
                    this.f58493b = r1;
                    return 1;
                } else if (4 == this.f58492a) {
                    ?? r12 = (T) new ShareFromFrsMsgData();
                    r12.setName(optJSONObject.optString("forumName"));
                    r12.setImageUrl(optJSONObject.optString("themeImageUrl"));
                    r12.setMemberNum(optJSONObject.optInt("memberNum"));
                    r12.setPostNum(optJSONObject.optInt("postNum"));
                    this.f58493b = r12;
                    return 2;
                } else {
                    return -1;
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }
}
