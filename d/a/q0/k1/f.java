package d.a.q0.k1;

import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.atomData.MissonDetailsActivityConfig;
import com.baidu.tbadk.core.atomData.SubPbActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.w2.w;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;
import tbclient.App;
import tbclient.GoodsInfo;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ForumData f59878a;

    /* renamed from: b  reason: collision with root package name */
    public int f59879b;

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<d> f59880c;

    /* renamed from: d  reason: collision with root package name */
    public AdvertAppInfo f59881d;

    /* renamed from: e  reason: collision with root package name */
    public String f59882e;

    /* renamed from: f  reason: collision with root package name */
    public String f59883f;

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<AlaInfoData> f59884g;

    /* renamed from: h  reason: collision with root package name */
    public int f59885h;

    /* renamed from: i  reason: collision with root package name */
    public String f59886i;
    public String j;
    public MetaData k;
    public int l;
    public int m;

    public f() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59879b = 0;
        this.f59880c = null;
        this.f59881d = null;
        this.f59880c = new LinkedList<>();
        this.f59884g = new LinkedList<>();
    }

    public AdvertAppInfo a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f59881d : (AdvertAppInfo) invokeV.objValue;
    }

    public final void b(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) || (optJSONArray = jSONObject.optJSONArray("app")) == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return;
        }
        App.Builder builder = new App.Builder();
        builder.id = optJSONObject.optString("id");
        builder.type = Integer.valueOf(optJSONObject.optInt("type", 0));
        builder.pos = Integer.valueOf(optJSONObject.optInt(IAdRequestParam.POS, 0));
        builder.icon_url = optJSONObject.optString("icon_url");
        builder.icon_link = optJSONObject.optString("icon_link");
        builder.app_name = optJSONObject.optString("app_name");
        builder.app_desc = optJSONObject.optString("app_desc");
        builder.p_name = optJSONObject.optString("p_name");
        builder.p_url = optJSONObject.optString("p_url");
        builder.img_url = optJSONObject.optString(BigdayActivityConfig.IMG_URL);
        builder.app_time = Integer.valueOf(optJSONObject.optInt("app_time", 0));
        builder.web_url = optJSONObject.optString("web_url");
        builder.ad_id = optJSONObject.optString(LegoListActivityConfig.AD_ID);
        builder.id = optJSONObject.optString("id");
        builder.name = optJSONObject.optString("name");
        builder.url_type = Integer.valueOf(optJSONObject.optInt("url_type", 0));
        builder.url = optJSONObject.optString("url");
        builder.ios_url = optJSONObject.optString("ios_url");
        builder.apk_url = optJSONObject.optString("apk_url");
        builder.apk_name = optJSONObject.optString("apk_name");
        builder.pos_name = optJSONObject.optString("pos_name");
        builder.first_name = optJSONObject.optString("first_name");
        builder.second_name = optJSONObject.optString("second_name");
        builder.cpid = Integer.valueOf(optJSONObject.optInt("cpid", 0));
        builder.abtest = optJSONObject.optString("abtest");
        builder.plan_id = Integer.valueOf(optJSONObject.optInt("plan_id", 0));
        builder.user_id = optJSONObject.optString("user_id");
        builder.price = optJSONObject.optString("price");
        builder.verify = optJSONObject.optString(SmsLoginView.f.j);
        builder.ext_info = optJSONObject.optString("ext_info");
        builder.pos_name = optJSONObject.optString("pos_name");
        GoodsInfo c2 = c(optJSONObject);
        if (c2 != null) {
            ArrayList arrayList = new ArrayList();
            builder.goods_info = arrayList;
            arrayList.add(c2);
        }
        builder.loc_code = optJSONObject.optString("loc_code");
        App build = builder.build(true);
        this.f59881d = new AdvertAppInfo();
        App c3 = w.o().c(build, Cmatch.PIC_PAGE);
        if (c3 != null) {
            this.f59881d.W3 = true;
            build = c3;
        }
        this.f59881d.B4(build);
        this.f59881d.X3 = "c0111";
    }

    public final GoodsInfo c(JSONObject jSONObject) {
        InterceptResult invokeL;
        JSONObject optJSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, jSONObject)) == null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("goods_info");
            if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
                return null;
            }
            GoodsInfo.Builder builder = new GoodsInfo.Builder();
            builder.id = Integer.valueOf(optJSONObject.optInt("id", 0));
            builder.user_name = optJSONObject.optString("user_name");
            builder.user_portrait = optJSONObject.optString("user_portrait");
            builder.thread_title = optJSONObject.optString(MissonDetailsActivityConfig.THREAD_TITLE);
            builder.thread_pic = optJSONObject.optString("thread_pic");
            builder.pop_window_text = optJSONObject.optString("pop_window_text");
            builder.goods_style = Integer.valueOf(optJSONObject.optInt("goods_style", 0));
            builder.label_visible = Integer.valueOf(optJSONObject.optInt("label_visible", 0));
            builder.label_text = optJSONObject.optString("label_text");
            builder.rank_level = Integer.valueOf(optJSONObject.optInt("rank_level", 0));
            builder.thread_type = optJSONObject.optString("thread_type");
            builder.button_text = optJSONObject.optString(GameGuideConfigInfo.KEY_BUTTON_TEXT);
            builder.card_desc = optJSONObject.optString("card_desc");
            builder.card_tag = optJSONObject.optString("card_tag");
            builder.tag_name = optJSONObject.optString("tag_name");
            builder.ad_source = optJSONObject.optString("ad_source");
            builder.tag_name_url = optJSONObject.optString("tag_name_url");
            builder.tag_name_wh = optJSONObject.optString("tag_name_wh");
            builder.lego_card = optJSONObject.optString("lego_card");
            return builder.build(true);
        }
        return (GoodsInfo) invokeL.objValue;
    }

    public LinkedList<AlaInfoData> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f59884g : (LinkedList) invokeV.objValue;
    }

    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f59882e : (String) invokeV.objValue;
    }

    public ForumData f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f59878a : (ForumData) invokeV.objValue;
    }

    public LinkedList<d> g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f59880c : (LinkedList) invokeV.objValue;
    }

    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f59879b : invokeV.intValue;
    }

    public int i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f59885h : invokeV.intValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f59883f : (String) invokeV.objValue;
    }

    public final void k(JSONObject jSONObject, boolean z) {
        JSONArray optJSONArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048586, this, jSONObject, z) == null) || jSONObject == null || (optJSONArray = jSONObject.optJSONArray("recom_ala_info")) == null) {
            return;
        }
        if (z) {
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                AlaInfoData alaInfoData = new AlaInfoData();
                alaInfoData.parserJson(optJSONArray.optJSONObject(i2));
                this.f59884g.addLast(alaInfoData);
            }
            return;
        }
        for (int length = optJSONArray.length() - 1; length >= 0; length--) {
            AlaInfoData alaInfoData2 = new AlaInfoData();
            alaInfoData2.parserJson(optJSONArray.optJSONObject(length));
            this.f59884g.addFirst(alaInfoData2);
        }
    }

    public void l(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048587, this, str, z) == null) {
            try {
                m(new JSONObject(str), Boolean.valueOf(z));
            } catch (Exception e2) {
                BdLog.detailException(e2);
            }
        }
    }

    public void m(JSONObject jSONObject, Boolean bool) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, jSONObject, bool) == null) || jSONObject == null) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("forum");
            if (optJSONObject != null) {
                ForumData forumData = new ForumData();
                this.f59878a = forumData;
                forumData.parserJson(optJSONObject);
                optJSONObject.optString("id");
                this.f59882e = optJSONObject.optString("frist_class");
                this.f59883f = optJSONObject.optString("second_class");
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("thread");
            if (optJSONObject2 != null) {
                JSONObject optJSONObject3 = optJSONObject2.optJSONObject(NotificationCompat.CarExtender.KEY_AUTHOR);
                if (optJSONObject3 != null) {
                    MetaData metaData = new MetaData();
                    this.k = metaData;
                    metaData.setUserId(optJSONObject3.optString("user_id"));
                    this.k.setUserName(optJSONObject3.optString("user_name"));
                    this.k.setName_show(optJSONObject3.optString("nickname"));
                }
                this.j = optJSONObject2.optString("first_post_id");
                this.l = optJSONObject2.optInt("is_multiforum_thread");
            }
            JSONObject optJSONObject4 = jSONObject.optJSONObject(SubPbActivityConfig.KEY_ANTI);
            if (optJSONObject4 != null) {
                this.f59885h = optJSONObject4.optInt("reply_private_flag");
                this.f59886i = optJSONObject4.optString("voice_message");
            }
            this.m = jSONObject.optInt("show_adsense", 0);
            this.f59879b = jSONObject.optInt("pic_amount", 0);
            JSONArray optJSONArray = jSONObject.optJSONArray("pic_list");
            if (optJSONArray != null) {
                if (bool.booleanValue()) {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        d dVar = new d();
                        dVar.w(optJSONArray.optJSONObject(i2));
                        int h2 = dVar.h();
                        if (h2 >= 1 && h2 <= this.f59879b) {
                            this.f59880c.addLast(dVar);
                        }
                    }
                } else {
                    for (int length = optJSONArray.length() - 1; length >= 0; length--) {
                        d dVar2 = new d();
                        dVar2.w(optJSONArray.getJSONObject(length));
                        int h3 = dVar2.h();
                        if (h3 >= 1 && h3 <= this.f59879b) {
                            this.f59880c.addFirst(dVar2);
                        }
                    }
                }
            }
            k(jSONObject, bool.booleanValue());
            b(jSONObject);
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
    }
}
