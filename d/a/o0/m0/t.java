package d.a.o0.m0;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.baidu.adp.gif.NSGif;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.EmotionUtil;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.CollectEmotionData;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes4.dex */
public class t extends d.a.n0.w.p.c {

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<String> f61154e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public Set<String> f61155f = new HashSet();

    public t() {
        v();
    }

    @Override // d.a.n0.w.p.c
    public String b(int i2) {
        if (i2 >= this.f61154e.size()) {
            return null;
        }
        return this.f61154e.get(i2);
    }

    @Override // d.a.n0.w.p.c
    public int c() {
        ArrayList<String> arrayList = this.f61154e;
        if (arrayList == null || arrayList.size() == 0) {
            return 1;
        }
        return this.f61154e.size();
    }

    @Override // d.a.n0.w.p.c
    public d.a.c.k.d.a e() {
        return super.d();
    }

    @Override // d.a.n0.w.p.c
    public String f() {
        return d.a.n0.a0.d.a();
    }

    @Override // d.a.n0.w.p.c
    public String g() {
        return "用户收藏表情";
    }

    @Override // d.a.n0.w.p.c
    public EmotionGroupType h() {
        return EmotionGroupType.USER_COLLECT;
    }

    @Override // d.a.n0.w.p.c
    public int i() {
        return 0;
    }

    @Override // d.a.n0.w.p.c
    public boolean j() {
        return true;
    }

    @Override // d.a.n0.w.p.c
    public int l() {
        return 0;
    }

    @Override // d.a.n0.w.p.c
    public boolean m(String str) {
        return this.f61155f.contains(str);
    }

    @Override // d.a.n0.w.p.c
    public d.a.c.k.d.a n(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        Throwable th;
        FileInputStream fileInputStream;
        File file = new File(t(str).getAbsolutePath().replace("_s.jpg", "_b.gif"));
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            byteArrayOutputStream = null;
            th = th2;
            fileInputStream = null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(1024);
            try {
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 1024);
                        if (read != -1) {
                            byteArrayOutputStream.write(bArr, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            d.a.c.k.d.a aVar = new d.a.c.k.d.a(NSGif.f(byteArray, 0, byteArray.length));
                            d.a.c.e.m.a.c(fileInputStream);
                            d.a.c.e.m.a.d(byteArrayOutputStream);
                            return aVar;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    d.a.c.e.m.a.c(fileInputStream);
                    d.a.c.e.m.a.d(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th = th3;
                d.a.c.e.m.a.c(fileInputStream);
                d.a.c.e.m.a.d(byteArrayOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e = e4;
            byteArrayOutputStream = null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            d.a.c.e.m.a.c(fileInputStream);
            d.a.c.e.m.a.d(byteArrayOutputStream);
            throw th;
        }
    }

    @Override // d.a.n0.w.p.c
    public d.a.c.k.d.a o(String str) {
        if (d.a.n0.a0.d.f52597d.equals(str)) {
            return new d.a.c.k.d.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_emotion_set_n), false);
        }
        Bitmap image = FileHelper.getImage(t(str).getAbsolutePath());
        if (image == null) {
            return null;
        }
        return new d.a.c.k.d.a(image, false, str);
    }

    public File t(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String replace = str.replace(EmotionUtil.NEW_EMOTION_SHARPTEXT_PREFIX, "");
        String replace2 = replace.substring(0, replace.indexOf(",")).replace("collect_", "");
        if (replace2.contains("_")) {
            replace2 = replace2.substring(replace2.indexOf("_") + 1);
        }
        return new File(TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.a.n0.a0.d.b() + "/" + replace2 + "_s.jpg");
    }

    public boolean u(String str) {
        if (this.f61154e != null && !TextUtils.isEmpty(str)) {
            Iterator<String> it = this.f61154e.iterator();
            while (it.hasNext()) {
                if (it.next().contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void v() {
        s(2);
        p(4);
        d.a.c.k.d.a aVar = new d.a.c.k.d.a(BitmapFactory.decodeResource(TbadkCoreApplication.getInst().getApp().getResources(), R.drawable.icon_bar_collection), false);
        super.r(aVar);
        super.q(aVar);
        w();
    }

    public void w() {
        List<CollectEmotionData> n = g.k().n(TbadkCoreApplication.getCurrentAccountForEmotion());
        this.f61154e.clear();
        this.f61155f.clear();
        for (CollectEmotionData collectEmotionData : n) {
            this.f61154e.add(collectEmotionData.sharpText);
            this.f61155f.add(collectEmotionData.sharpText);
        }
    }
}
