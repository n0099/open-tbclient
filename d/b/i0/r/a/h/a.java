package d.b.i0.r.a.h;

import android.os.Environment;
import android.text.TextUtils;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.advert.sdk.data.AdInfo;
import d.b.b.e.j.a.e;
import d.b.b.e.p.q;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes4.dex */
public class a extends BdAsyncTask<Void, Void, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    public static final String f59678b = Environment.getExternalStorageDirectory() + "/tieba/.advideo";

    /* renamed from: c  reason: collision with root package name */
    public static final String f59679c = File.separator;

    /* renamed from: a  reason: collision with root package name */
    public AdInfo f59680a;

    public final void b(boolean z, File file) {
        if (z && file != null) {
            File file2 = new File(f59678b + f59679c + (q.c(this.f59680a.adVideoUrl) + ".mp4"));
            if (file2.exists()) {
                file2.delete();
            }
            if (file.renameTo(file2)) {
                this.f59680a.videoLocalPath = file2.getAbsolutePath();
            } else {
                this.f59680a.videoLocalPath = "";
            }
        } else {
            this.f59680a.videoLocalPath = "";
        }
        d.b.i0.r.a.i.a.j(this.f59680a);
    }

    public void c(AdInfo adInfo) {
        this.f59680a = adInfo;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008f, code lost:
        if (r12.equalsIgnoreCase(r11.f59680a.videoMd5) == false) goto L24;
     */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Boolean doInBackground(Void... voidArr) {
        String str = f59678b + f59679c + "advideo.temp";
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        boolean z = false;
        try {
            new File(f59678b).mkdirs();
            if (!file.createNewFile()) {
                b(false, null);
                return Boolean.FALSE;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        e eVar = new e();
        eVar.b().s(this.f59680a.adVideoUrl);
        boolean c2 = new d.b.b.e.j.a.c(eVar).c(str, null, 3, 3000, -1, -1, true, true);
        try {
            if (TextUtils.isEmpty(this.f59680a.videoMd5)) {
                b(c2, file);
                return Boolean.valueOf(c2);
            }
            String b2 = q.b(new FileInputStream(str));
            if (TextUtils.isEmpty(b2)) {
                c2 = false;
            }
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
        }
        z = c2;
        b(z, file);
        return Boolean.valueOf(z);
    }
}
