package d.a.n0.e2.k.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class x0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53537a;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f53538a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f53539b;

        public a(String str, byte[] bArr) {
            this.f53538a = null;
            this.f53539b = null;
            this.f53538a = str;
            this.f53539b = bArr;
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
            int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f53538a, this.f53539b, x0.this.f53537a.getPageActivity());
            if (saveImageFileByUser != -2) {
                if (saveImageFileByUser != 0) {
                    return x0.this.f53537a.getString(R.string.save_fail);
                }
                return x0.this.f53537a.getString(R.string.save_image_to_album);
            }
            return FileHelper.getSdErrorString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            x0.this.f53537a.showToast(str);
        }
    }

    public x0(TbPageContext tbPageContext) {
        this.f53537a = tbPageContext;
    }

    public void b(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }
}
