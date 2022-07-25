package com.repackage;

import android.location.Address;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
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
import com.baidu.tbadk.img.ImageUploader;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class qx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public BdUniqueId b;
    public px8 c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<nx8, Integer, ox8> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qx8 a;

        public b(qx8 qx8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qx8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qx8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public ox8 doInBackground(nx8... nx8VarArr) {
            InterceptResult invokeL;
            nx8 nx8Var;
            ImageUploadResult.picInfo picinfo;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, nx8VarArr)) == null) {
                String str = null;
                if (nx8VarArr.length == 0 || (nx8Var = nx8VarArr[0]) == null) {
                    return null;
                }
                yb ybVar = new yb("images", TbMd5.getNameMd5FromUrl(nx8Var.i + 42), DiskFileOperate.Action.READ);
                ybVar.setSubFolder(true);
                ybVar.setIsFormatData(false);
                ImageUploadResult uploadInBackground = new ImageUploader(null).uploadInBackground(c(ybVar.buildPath(), ybVar.getName()), true, false);
                if (uploadInBackground != null && (picinfo = uploadInBackground.picInfo) != null) {
                    ImageUploadResult.PicDetailedInfo picDetailedInfo = picinfo.originPic;
                    if (picDetailedInfo != null && !StringUtils.isNull(picDetailedInfo.picUrl)) {
                        str = uploadInBackground.picInfo.originPic.picUrl;
                    } else {
                        ImageUploadResult.PicDetailedInfo picDetailedInfo2 = uploadInBackground.picInfo.bigPic;
                        if (picDetailedInfo2 != null && !StringUtils.isNull(picDetailedInfo2.picUrl)) {
                            str = uploadInBackground.picInfo.bigPic.picUrl;
                        } else {
                            ImageUploadResult.PicDetailedInfo picDetailedInfo3 = uploadInBackground.picInfo.smallPic;
                            if (picDetailedInfo3 != null && !StringUtils.isNull(picDetailedInfo3.picUrl)) {
                                str = uploadInBackground.picInfo.smallPic.picUrl;
                            }
                        }
                    }
                }
                if (StringUtils.isNull(str)) {
                    str = nx8Var.j;
                }
                NetWork netWork = new NetWork();
                netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.POST_THREAD_ADDRESS);
                netWork.getNetContext().getRequest().mIsNeedTbs = true;
                netWork.addPostData("anonymous", "1");
                netWork.addPostData("can_no_forum", "0");
                netWork.addPostData("is_feedback", "0");
                if (TbadkCoreApplication.getInst().getNewVcodeWebviewCrashCount() < 3) {
                    netWork.addPostData("vcode_tag", "12");
                }
                netWork.addPostData("new_vcode", "1");
                netWork.addPostData("content", nx8Var.m);
                netWork.addPostData("fid", nx8Var.e);
                netWork.addPostData(TiebaStatic.Params.H5_FORUM_NAME, nx8Var.f);
                netWork.addPostData("is_hide", "0");
                netWork.addPostData(IntentConfig.CALL_FROM, "2");
                netWork.addPostData("title", nx8Var.m);
                netWork.addPostData("is_ntitle", "1");
                netWork.addPostData("st_type", "notitle");
                netWork.addPostData("is_location", "2");
                Address j = jf.n().j(false);
                if (j != null && TbadkCoreApplication.getInst().getIsLocationOn() && !TbConfig.getPositionPagerId().equals(nx8Var.e)) {
                    netWork.addPostData("lbs", String.valueOf(j.getLatitude()) + "," + String.valueOf(j.getLongitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LAT, String.valueOf(j.getLatitude()));
                    netWork.addPostData(SuggestAddrField.KEY_LNG, String.valueOf(j.getLongitude()));
                }
                LocationData b = nj8.a().b();
                if (b != null) {
                    netWork.addPostData("name", b.getFormatted_address());
                    netWork.addPostData("sn", b.getSn());
                }
                netWork.addPostData("is_link_thread", "0");
                if (TbadkCoreApplication.getCurrentAccountInfo() != null) {
                    netWork.addPostData("name_show", TbadkCoreApplication.getCurrentAccountNameShow());
                }
                netWork.addPostData("tbopen_app_key", nx8Var.a);
                netWork.addPostData("tbopen_app_icon", nx8Var.d);
                netWork.addPostData("tbopen_app_name", nx8Var.c);
                netWork.addPostData("share_abstract", nx8Var.h);
                netWork.addPostData("share_image", str);
                netWork.addPostData("share_h5_url", nx8Var.k);
                netWork.addPostData("share_swan_app_key", nx8Var.b);
                netWork.addPostData("share_swan_path", nx8Var.l);
                String postNetData = netWork.postNetData();
                ox8 ox8Var = new ox8();
                try {
                    JSONObject jSONObject = new JSONObject(postNetData);
                    jSONObject.optString("msg");
                    jSONObject.optString("pre_msg");
                    ox8Var.b = nx8Var.e;
                    ox8Var.c = jSONObject.optString("tid");
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
                if (errorData.error_code != 0 && !ni.z()) {
                    errorData.setError_msg(TbadkCoreApplication.getInst().getApp().getString(R.string.obfuscated_res_0x7f0f0c17));
                }
                ox8Var.a = errorData;
                try {
                    new AntiData().parserJson(new JSONObject(postNetData).optJSONObject("anti_stat"));
                } catch (Exception unused2) {
                }
                return ox8Var;
            }
            return (ox8) invokeL.objValue;
        }

        public String c(String str, String str2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2)) == null) {
                String str3 = this.a.a + str2;
                if (str != null) {
                    return this.a.a + str + "/" + str2;
                }
                return str3;
            }
            return (String) invokeLL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: d */
        public void onPostExecute(ox8 ox8Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ox8Var) == null) || this.a.c == null) {
                return;
            }
            this.a.c.a(ox8Var);
        }

        public /* synthetic */ b(qx8 qx8Var, a aVar) {
            this(qx8Var);
        }
    }

    public qx8(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = BdBaseApplication.getInst().getContext().getCacheDir().getAbsolutePath() + "/";
        this.b = bdUniqueId;
    }

    public void c(px8 px8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, px8Var) == null) {
            this.c = px8Var;
        }
    }

    public void d(nx8 nx8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, nx8Var) == null) {
            b bVar = new b(this, null);
            bVar.setTag(this.b);
            bVar.execute(nx8Var);
        }
    }
}
