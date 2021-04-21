package d.b.j0.f2;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.img.ImageUploadResult;
/* loaded from: classes3.dex */
public class a {

    /* loaded from: classes3.dex */
    public static class b extends BdAsyncTask<String, Integer, ImageUploadResult> {

        /* renamed from: a  reason: collision with root package name */
        public String f56380a;

        /* renamed from: b  reason: collision with root package name */
        public c f56381b;

        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ImageUploadResult doInBackground(String... strArr) {
            return new d.b.i0.b0.f("user_pics").j(FileHelper.getFileDireciory(this.f56380a), false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(ImageUploadResult imageUploadResult) {
            String str;
            super.onPostExecute(imageUploadResult);
            if (this.f56381b != null) {
                int i = 0;
                if (imageUploadResult != null) {
                    i = imageUploadResult.error_code;
                    str = imageUploadResult.error_msg;
                } else {
                    str = "";
                }
                this.f56381b.a(i, str, imageUploadResult);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i, String str, ImageUploadResult imageUploadResult);
    }

    public void a(String str, c cVar) {
        if (StringUtils.isNull(str)) {
            return;
        }
        b bVar = new b();
        bVar.f56380a = str;
        bVar.f56381b = cVar;
        bVar.execute("");
    }
}
