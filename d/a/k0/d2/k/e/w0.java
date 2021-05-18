package d.a.k0.d2.k.e;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tieba.R;
/* loaded from: classes5.dex */
public class w0 {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f53281a;

    /* loaded from: classes5.dex */
    public class a extends BdAsyncTask<String, Integer, String> {

        /* renamed from: a  reason: collision with root package name */
        public String f53282a;

        /* renamed from: b  reason: collision with root package name */
        public byte[] f53283b;

        public a(String str, byte[] bArr) {
            this.f53282a = null;
            this.f53283b = null;
            this.f53282a = str;
            this.f53283b = bArr;
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
            int saveImageFileByUser = FileHelper.saveImageFileByUser(this.f53282a, this.f53283b, w0.this.f53281a.getPageActivity());
            if (saveImageFileByUser != -2) {
                if (saveImageFileByUser != 0) {
                    return w0.this.f53281a.getString(R.string.save_fail);
                }
                return w0.this.f53281a.getString(R.string.save_image_to_album);
            }
            return FileHelper.getSdErrorString();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            super.onPostExecute((a) str);
            w0.this.f53281a.showToast(str);
        }
    }

    public w0(TbPageContext tbPageContext) {
        this.f53281a = tbPageContext;
    }

    public void b(String str, byte[] bArr) {
        new a(str, bArr).execute(new String[0]);
    }
}
