package com.example.image_picker;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.y;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class PostAsyncTask extends BdAsyncTask<String, Object, ResultData> {
    private String barId;
    private PostCallback callback;
    private String url;

    /* loaded from: classes6.dex */
    public interface PostCallback {
        void onFailure(ResultData resultData);

        void onSuccess(ResultData resultData);
    }

    public PostAsyncTask(String str, String str2, PostCallback postCallback) {
        this.url = str;
        this.barId = str2;
        this.callback = postCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ResultData doInBackground(String... strArr) {
        ResultData resultData;
        y yVar = new y(TbConfig.SERVER_ADDRESS + "c/c/bawu/updateAvatar");
        yVar.addPostData("forum_id", this.barId);
        yVar.addPostData(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, this.url);
        yVar.addPostData("tbs", TbadkCoreApplication.getInst().getTbs());
        String postNetData = yVar.postNetData();
        if (yVar.aWu().aWW().isRequestSuccess()) {
            try {
                resultData = (ResultData) OrmObject.objectWithJsonStr(postNetData, ResultData.class);
            } catch (Exception e) {
                BdLog.detailException(e);
                resultData = new ResultData();
                resultData.error_code = -1000;
            }
        } else {
            resultData = new ResultData();
            resultData.error_code = yVar.getServerErrorCode();
            resultData.error_msg = yVar.getErrorString();
        }
        resultData.url = this.url;
        return resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(ResultData resultData) {
        super.onPostExecute((PostAsyncTask) resultData);
        if (resultData.error_code == 0) {
            this.callback.onSuccess(resultData);
        } else {
            this.callback.onFailure(resultData);
        }
    }

    /* loaded from: classes6.dex */
    public static class ResultData extends OrmObject implements Serializable {
        public int error_code = 0;
        public String error_msg = "";
        public String url = "";

        public String toString() {
            return "ResultData{error_code=" + this.error_code + ", error_msg='" + this.error_msg + "'}";
        }
    }
}
