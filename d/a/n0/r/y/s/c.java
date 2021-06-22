package d.a.n0.r.y.s;

import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import d.a.n0.r.y.l;
import d.a.n0.r.y.n;
import d.a.n0.r.y.o;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends n {

    /* renamed from: c  reason: collision with root package name */
    public l f54182c;

    public c(l lVar) {
        super(lVar);
        this.f54182c = lVar;
    }

    @Override // d.a.n0.r.y.n
    public String g() {
        return "TBHY_COMMON_Image";
    }

    @o(isAsync = false, value = "scanBigImages")
    public void sanBigImages(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("imageUrls");
        int optInt = jSONObject.optInt("clickIndex");
        int length = optJSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>();
        ConcurrentHashMap<String, ImageUrlData> concurrentHashMap = new ConcurrentHashMap<>();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
            if (jSONObject2 != null) {
                String string = jSONObject2.getString("bigImageUrl");
                String string2 = jSONObject2.getString("originImageUrl");
                if (!TextUtils.isEmpty(string)) {
                    arrayList.add(string);
                    if (!TextUtils.isEmpty(string2)) {
                        ImageUrlData imageUrlData = new ImageUrlData();
                        imageUrlData.imageUrl = string;
                        imageUrlData.originalUrl = string2;
                        concurrentHashMap.put(string, imageUrlData);
                    }
                }
            }
        }
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(optInt);
        bVar.C(true);
        bVar.J(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.F(true);
        bVar.w(concurrentHashMap);
        bVar.H(true);
        d(new CustomMessage(2010000, bVar.v(this.f54182c.f())));
    }

    @o("selectPhotos")
    public void selectPhotos(JSONObject jSONObject) throws JSONException {
        JSONArray optJSONArray;
        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
        LinkedList<ImageFileInfo> linkedList = new LinkedList<>();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("selectPhotos")) != null && optJSONArray.length() > 0) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                ImageFileInfo imageFileInfo = new ImageFileInfo();
                imageFileInfo.setFilePath(((JSONObject) optJSONArray.get(i2)).optString("filePath"));
                linkedList.add(imageFileInfo);
            }
        }
        writeImagesInfo.setChosedFiles(linkedList);
        writeImagesInfo.setMaxImagesAllowed(9);
        AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig(b(), writeImagesInfo.toJsonString(), true, true);
        albumActivityConfig.getIntent().putExtra(AlbumActivityConfig.CAMERA_REQUEST_FROM, 5);
        albumActivityConfig.setRequestCode(12015);
        d(new CustomMessage(2002001, albumActivityConfig));
    }
}
