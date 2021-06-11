package d.a.n0.e2.k.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class x0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57226a;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f57227a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f57228b;

        public a(String str, byte[] bArr) {
            this.f57227a = null;
            this.f57228b = null;
            this.f57227a = str;
            this.f57228b = bArr;
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
            int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f57227a, this.f57228b, x0.this.f57226a.getPageActivity());
            if (saveImageFileByUser != -2) {
                if (saveImageFileByUser != 0) {
                    return x0.this.f57226a.getString(R.string.save_fail);
                }
                return x0.this.f57226a.getString(R.string.save_image_to_album);
            }
            return FileHelper.getSdErrorString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            x0.this.f57226a.showToast(str);
        }
    }

    public x0(TbPageContext tbPageContext) {
        this.f57226a = tbPageContext;
    }

    public void b(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }
}
