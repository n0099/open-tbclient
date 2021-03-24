package d.b.i0.e2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes5.dex */
public class a {

    /* loaded from: classes5.dex */
    public static class b extends BdAsyncTask<String, Integer, ImageUploadResult> {

        /* renamed from: a  reason: collision with root package name */
        public String f54517a;

        /* renamed from: b  reason: collision with root package name */
        public c f54518b;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            return new d.b.h0.b0.f("user_pics").j(FileHelper.getFileDireciory(this.f54517a), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            String str;
            super.onPostExecute(imageUploadResult);
            if (this.f54518b != null) {
                int i = 0;
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                } else {
                    str = "";
                }
                this.f54518b.a(i, str, imageUploadResult);
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, c cVar) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b bVar = new b();
        bVar.f54517a = str;
        bVar.f54518b = cVar;
        bVar.execute("");
    }
}
