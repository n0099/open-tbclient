package d.a.q0.g1.b;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.view.ShareCardView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.s.a;
import java.net.URLEncoder;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BaseActivity<?> f56904a;

    /* renamed from: b  reason: collision with root package name */
    public SparseArray<String> f56905b;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareItem f56906e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f56907f;

        public a(b bVar, ShareItem shareItem) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareItem};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56907f = bVar;
            this.f56906e = shareItem;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                d.a.d.e.p.a.a(this.f56906e.t);
                l.M(this.f56907f.f56904a.getActivity(), view.getResources().getString(R.string.copy_pb_url_success));
            }
        }
    }

    /* renamed from: d.a.q0.g1.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1391b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56909f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f56910g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ long f56911h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ ShareFromTopicMsgData f56912i;
        public final /* synthetic */ b j;

        public C1391b(b bVar, ShareCardView shareCardView, long j, String str, long j2, ShareFromTopicMsgData shareFromTopicMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView, Long.valueOf(j), str, Long.valueOf(j2), shareFromTopicMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = bVar;
            this.f56908e = shareCardView;
            this.f56909f = j;
            this.f56910g = str;
            this.f56911h = j2;
            this.f56912i = shareFromTopicMsgData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.j.f56904a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56908e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(this.j.f56904a.getActivity(), this.f56909f, this.f56910g, this.f56911h, "from_share", this.f56908e.getLeaveMsg(), this.f56912i.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56913e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f56914f;

        public c(b bVar, ShareCardView shareCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56914f = bVar;
            this.f56913e = shareCardView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f56914f.f56904a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56913e.getChatMsgView().getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56915e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ long f56916f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f56917g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f56918h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ String f56919i;
        public final /* synthetic */ ShareFromTopicMsgData j;
        public final /* synthetic */ b k;

        public d(b bVar, ShareCardView shareCardView, long j, String str, String str2, String str3, ShareFromTopicMsgData shareFromTopicMsgData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView, Long.valueOf(j), str, str2, str3, shareFromTopicMsgData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = bVar;
            this.f56915e = shareCardView;
            this.f56916f = j;
            this.f56917g = str;
            this.f56918h = str2;
            this.f56919i = str3;
            this.j = shareFromTopicMsgData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.k.f56904a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56915e.getChatMsgView().getWindowToken(), 2);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002005, new PersonalChatActivityConfig(this.k.f56904a.getActivity(), this.f56916f, this.f56917g, this.f56918h, this.f56919i, 0, this.f56915e.getLeaveMsg(), this.j.toChatMessageContent())));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ShareCardView f56920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f56921f;

        public e(b bVar, ShareCardView shareCardView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, shareCardView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f56921f = bVar;
            this.f56920e = shareCardView;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                ((InputMethodManager) this.f56921f.f56904a.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(this.f56920e.getChatMsgView().getWindowToken(), 2);
                aVar.dismiss();
            }
        }
    }

    public b(BaseActivity<?> baseActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f56905b = null;
        this.f56904a = baseActivity;
    }

    public final SparseArray<String> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.f56905b == null) {
                SparseArray<String> sparseArray = new SparseArray<>(8);
                this.f56905b = sparseArray;
                sparseArray.put(2, "topic_wx_timeline");
                this.f56905b.put(3, "topic_wx_friend");
                this.f56905b.put(4, "topic_qq_zone");
                this.f56905b.put(5, "topic_tencent_weibo");
                this.f56905b.put(6, "topic_sina_weibo");
            }
            return this.f56905b;
        }
        return (SparseArray) invokeV.objValue;
    }

    public void c(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, long j2, d.a.q0.g1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j), str, Long.valueOf(j2), eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f56904a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f56904a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new C1391b(this, shareCardView, j, str, j2, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new c(this, shareCardView));
        aVar.create(this.f56904a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void d(ShareFromTopicMsgData shareFromTopicMsgData, long j, String str, String str2, String str3, d.a.q0.g1.c.e eVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{shareFromTopicMsgData, Long.valueOf(j), str, str2, str3, eVar}) == null) || eVar == null || eVar.h() == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f56904a.getActivity());
        ShareCardView shareCardView = new ShareCardView(this.f56904a.getActivity());
        shareCardView.setData(shareFromTopicMsgData);
        aVar.setContentViewSize(1);
        aVar.setContentView(shareCardView);
        aVar.setPositiveButton(R.string.share, new d(this, shareCardView, j, str, str2, str3, shareFromTopicMsgData));
        aVar.setNegativeButton(R.string.cancel, new e(this, shareCardView));
        aVar.create(this.f56904a.getPageContext()).show();
        if (k.isEmpty(shareFromTopicMsgData.getImageUrl())) {
            return;
        }
        shareCardView.c(shareFromTopicMsgData.getImageUrl(), false);
    }

    public void e(String str, String str2, String str3, String str4, String str5, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{str, str2, str3, str4, str5, Boolean.valueOf(z)}) == null) {
            if (TextUtils.isEmpty(str) && z) {
                BaseActivity<?> baseActivity = this.f56904a;
                baseActivity.showToast(baseActivity.getActivity().getString(R.string.no_hot_topic_data));
                return;
            }
            if (StringUtils.isNull(str3)) {
                str3 = "http://tieba.baidu.com/mo/q/hotMessage?topic_id=" + str + "&topic_name=" + URLEncoder.encode(str2);
            }
            Uri parse = StringUtils.isNull(str4) ? null : Uri.parse(str4);
            ShareItem shareItem = new ShareItem();
            shareItem.r = str2;
            shareItem.s = str5;
            shareItem.t = str3;
            shareItem.f12888b = true;
            shareItem.q = str;
            shareItem.v = parse;
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig((Context) this.f56904a.getActivity(), shareItem, true, b());
            shareDialogConfig.setCopyLinkListener(new a(this, shareItem));
            shareDialogConfig.setIsCopyLink(true);
            this.f56904a.sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }
}
