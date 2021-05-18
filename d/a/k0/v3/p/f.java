package d.a.k0.v3.p;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.pass.ecommerce.bean.SuggestAddrField;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.TbMd5;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.ImageUploadResult;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.tencent.connect.common.Constants;
import d.a.c.e.p.j;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f62799a = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f62800b;

    /* renamed from: c  reason: collision with root package name */
    public e f62801c;

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<c, Integer, d> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public d doInBackground(c... cVarArr) {
            c cVar;
            ImageUploadResult.picInfo picinfo;
            String str = null;
            if (cVarArr.length == 0 || (cVar = cVarArr[0]) == null) {
                return null;
            }
            d.a.c.e.a.f.c cVar2 = new d.a.c.e.a.f.c("images", TbMd5.getNameMd5FromUrl(cVar.f62795i + 42), DiskFileOperate.Action.READ);
            cVar2.setSubFolder(true);
            cVar2.setIsFormatData(false);
            ImageUploadResult k = new d.a.j0.b0.f(null).k(c(cVar2.buildPath(), cVar2.getName()), true, false);
            if (k != null && (picinfo = k.picInfo) != null) {
                ImageUploadResult.PicDetailedInfo picDetailedInfo = picinfo.originPic;
                if (picDetailedInfo != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                    str = k.picInfo.originPic.picUrl;
                } else {
                    ImageUploadResult.PicDetailedInfo picDetailedInfo2 = k.picInfo.bigPic;
                    if (picDetailedInfo2 != null && !StringUtils.isNull(picDetailedInfo2.picUrl)) {
                        str = k.picInfo.bigPic.picUrl;
                    } else {
                        ImageUploadResult.PicDetailedInfo picDetailedInfo3 = k.picInfo.smallPic;
                        if (picDetailedInfo3 != null && !StringUtils.isNull(picDetailedInfo3.picUrl)) {
                            str = k.picInfo.smallPic.picUrl;
                        }
                    }
                }
            }
            if (StringUtils.isNull(str)) {
                str = cVar.j;
            }
            NetWork netWork = new NetWork();
            netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
            netWork.getNetContext().getRequest().mIsNeedTbs = true;
            netWork.addPostData("anonymous", "1");
            netWork.addPostData("can_no_forum", "0");
            netWork.addPostData("is_feedback", "0");
            if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                netWork.addPostData("vcode_tag", Constants.VIA_REPORT_TYPE_SET_AVATAR);
            }
            netWork.addPostData("new_vcode", "1");
            netWork.addPostData("content", cVar.m);
            netWork.addPostData("fid", cVar.f62791e);
            netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, cVar.f62792f);
            netWork.addPostData("is_hide", "0");
            netWork.addPostData(IntentConfig.CALL_FROM, "2");
            netWork.addPostData("title", cVar.m);
            netWork.addPostData("is_ntitle", "1");
            netWork.addPostData("st_type", "notitle");
            netWork.addPostData("is_location", "2");
            Address h2 = d.a.c.e.i.a.l().h(false);
            if (h2 != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(cVar.f62791e)) {
                netWork.addPostData("lbs", String.valueOf(h2.getLatitude()) + "," + String.valueOf(h2.getLongitude()));
                netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(h2.getLatitude()));
                netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(h2.getLongitude()));
            }
            LocationData b2 = d.a.k0.d3.m0.b.a().b();
            if (b2 != null) {
                netWork.addPostData("name", b2.getFormatted_address());
                netWork.addPostData(IAdRequestParam.SN, b2.getSn());
            }
            netWork.addPostData("is_link_thread", "0");
            if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                netWork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
            }
            netWork.addPostData("tbopen_app_key", cVar.f62787a);
            netWork.addPostData("tbopen_app_icon", cVar.f62790d);
            netWork.addPostData("tbopen_app_name", cVar.f62789c);
            netWork.addPostData("share_abstract", cVar.f62794h);
            netWork.addPostData("share_image", str);
            netWork.addPostData("share_h5_url", cVar.k);
            netWork.addPostData("share_swan_app_key", cVar.f62788b);
            netWork.addPostData("share_swan_path", cVar.l);
            String postNetData = netWork.postNetData();
            d dVar = new d();
            try {
                JSONObject jSONObject = new JSONObject(postNetData);
                jSONObject.optString("msg");
                jSONObject.optString("pre_msg");
                dVar.f62797b = cVar.f62791e;
                dVar.f62798c = jSONObject.optString("tid");
                jSONObject.optString("pid");
                jSONObject.optString("video_id");
            } catch (Exception unused) {
            }
            ErrorData errorData = new ErrorData();
            if (netWork.getNetContext().getResponse().isRequestSuccess()) {
                errorData.parserJson(postNetData);
            } else {
                errorData.setError_code(netWork.isNetSuccess() ? netWork.getServerErrorCode() : netWork.getNetErrorCode());
                errorData.setError_msg(netWork.getErrorString());
            }
            if (errorData.error_code != 0 && !j.z()) {
                errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.neterror));
            }
            dVar.f62796a = errorData;
            try {
                new AntiData().parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
            } catch (Exception unused2) {
            }
            return dVar;
        }

        public String c(String str, String str2) {
            String str3 = f.this.f62799a + str2;
            if (str != null) {
                return f.this.f62799a + str + "/" + str2;
            }
            return str3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(d dVar) {
            if (f.this.f62801c != null) {
                f.this.f62801c.a(dVar);
            }
        }
    }

    public f(BdUniqueId bdUniqueId) {
        this.f62800b = bdUniqueId;
    }

    public void c(e eVar) {
        this.f62801c = eVar;
    }

    public void d(c cVar) {
        b bVar = new b();
        bVar.setTag(this.f62800b);
        bVar.execute(cVar);
    }
}
