package d.a.j0.d2.k.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class w0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52578a;

    /* loaded from: classes3.dex */
    public class a extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f52579a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f52580b;

        public a(String str, byte[] bArr) {
            this.f52579a = null;
            this.f52580b = null;
            this.f52579a = str;
            this.f52580b = bArr;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            super.cancel(true);
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onCancelled() {
            super.onCancelled();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(String... strArr) {
            int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f52579a, this.f52580b, w0.this.f52578a.getPageActivity());
            if (saveImageFileByUser != -2) {
                if (saveImageFileByUser != 0) {
                    return w0.this.f52578a.getString(R.string.save_fail);
                }
                return w0.this.f52578a.getString(R.string.save_image_to_album);
            }
            return FileHelper.getSdErrorString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            w0.this.f52578a.showToast(str);
        }
    }

    public w0(TbPageContext tbPageContext) {
        this.f52578a = tbPageContext;
    }

    public void b(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }
}
