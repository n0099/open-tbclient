package d.b.i0.s.b.g.a;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.pyramid.annotation.Service;
import com.baidu.pyramid.annotation.Singleton;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.img.WriteImagesInfo;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import d.b.b.e.m.e;
import d.b.g0.a.b1.d.d.c;
import d.b.g0.a.p.c.z;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@Singleton
@Service
/* loaded from: classes4.dex */
public class a implements z {

    /* renamed from: a  reason: collision with root package name */
    public c f60078a;

    /* renamed from: b  reason: collision with root package name */
    public CustomMessageListener f60079b = new C1523a(2921365);

    /* renamed from: d.b.i0.s.b.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1523a extends CustomMessageListener {

        /* renamed from: d.b.i0.s.b.g.a.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC1524a implements Runnable {
            public RunnableC1524a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f60078a = null;
                MessageManager.getInstance().unRegisterListener(a.this.f60079b);
            }
        }

        public C1523a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0016  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
        @Override // com.baidu.adp.framework.listener.MessageListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Intent intent;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Intent) {
                    intent = (Intent) data;
                    if (intent == null) {
                        String stringExtra = intent.getStringExtra(AlbumActivityConfig.ALBUM_RESULT);
                        WriteImagesInfo writeImagesInfo = new WriteImagesInfo();
                        writeImagesInfo.parseJson(stringExtra);
                        writeImagesInfo.updateQuality();
                        if (a.this.f60078a != null) {
                            ArrayList arrayList = new ArrayList();
                            LinkedList<ImageFileInfo> chosedFiles = writeImagesInfo.getChosedFiles();
                            if (chosedFiles != null && chosedFiles.size() > 0) {
                                for (ImageFileInfo imageFileInfo : chosedFiles) {
                                    if (imageFileInfo != null && !TextUtils.isEmpty(imageFileInfo.getFilePath())) {
                                        arrayList.add(imageFileInfo.getFilePath());
                                    }
                                }
                                a.this.f60078a.b(arrayList);
                            } else {
                                a.this.f60078a.a(QueryResponse.Options.CANCEL);
                            }
                        }
                    } else {
                        c cVar = a.this.f60078a;
                        if (cVar != null) {
                            cVar.a("error");
                        }
                    }
                    e.a().post(new RunnableC1524a());
                }
            }
            intent = null;
            if (intent == null) {
            }
            e.a().post(new RunnableC1524a());
        }
    }

    @Override // d.b.g0.a.p.c.z
    @TargetApi(19)
    public void a(Context context, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT < 19) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("source", "swan");
            jSONObject.put("from", "");
            jSONObject.put("url", new JSONArray(strArr));
            jSONObject.put("type", "0");
            jSONObject.put("index", String.valueOf(i));
            c(context, jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @Override // d.b.g0.a.p.c.z
    public void b(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        int optInt = jSONObject.optInt("index");
        JSONArray optJSONArray = jSONObject.optJSONArray("urls");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        int length = optJSONArray.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            String optString = optJSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                strArr[i] = optString;
            }
        }
        a(context, strArr, optInt);
    }

    public void c(Context context, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        jSONObject.optString("source");
        jSONObject.optString("from");
        jSONObject.optString("type");
        String optString = jSONObject.optString("index");
        JSONArray optJSONArray = jSONObject.optJSONArray("url");
        int d2 = d.b.b.e.m.b.d(optString, 0);
        int length = optJSONArray.length();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String optString2 = optJSONArray.optString(i);
            if (optString2 != null) {
                arrayList.add(optString2);
            }
        }
        ImageViewerConfig.b bVar = new ImageViewerConfig.b();
        bVar.x(arrayList);
        bVar.B(d2);
        bVar.C(true);
        bVar.G(true);
        bVar.I(true);
        bVar.K(arrayList.size() > 0 ? arrayList.get(0) : "");
        bVar.L(false);
        bVar.H(false);
        bVar.F(true);
        MessageManager.getInstance().sendMessage(new CustomMessage(2010000, bVar.v(context)));
    }
}
