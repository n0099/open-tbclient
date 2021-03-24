package com.example.image_picker;

import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class PostAsyncTask extends BdAsyncTask<String, Object, ResultData> {
    public String barId;
    public PostCallback callback;
    public String url;

    /* loaded from: classes6.dex */
    public interface PostCallback {
        void onFailure(ResultData resultData);

        void onSuccess(ResultData resultData);
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

    public PostAsyncTask(String str, String str2, PostCallback postCallback) {
        this.url = str;
        this.barId = str2;
        this.callback = postCallback;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public ResultData doInBackground(String... strArr) {
        ResultData resultData;
        NetWork netWork = new NetWork(TbConfig.SERVER_ADDRESS + "c/c/bawu/updateAvatar");
        netWork.addPostData("forum_id", this.barId);
        netWork.addPostData("avatar", this.url);
        netWork.addPostData(HttpRequest.TBS, TbadkCoreApplication.getInst().getTbs());
        String postNetData = netWork.postNetData();
        if (netWork.getNetContext().getResponse().isRequestSuccess()) {
            try {
                resultData = (ResultData) OrmObject.objectWithJsonStr(postNetData, ResultData.class);
            } catch (Exception e2) {
                BdLog.detailException(e2);
                resultData = new ResultData();
                resultData.error_code = -1000;
            }
        } else {
            ResultData resultData2 = new ResultData();
            resultData2.error_code = netWork.getServerErrorCode();
            resultData2.error_msg = netWork.getErrorString();
            resultData = resultData2;
        }
        resultData.url = this.url;
        return resultData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPostExecute(ResultData resultData) {
        super.onPostExecute((PostAsyncTask) resultData);
        if (resultData.error_code == 0) {
            this.callback.onSuccess(resultData);
        } else {
            this.callback.onFailure(resultData);
        }
    }
}
