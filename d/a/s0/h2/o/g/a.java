package d.a.s0.h2.o.g;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.AgreeView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.TbMemeImageView;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tbadk.widget.richText.TbRichTextMemeInfo;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.view.CustomBlueCheckRadioButton;
import com.baidu.tieba.pb.videopb.VideoPbFragment;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.tieba.usermute.UserMuteAddAndDelCustomMessage;
import com.baidu.tieba.usermute.UserMuteCheckCustomMessage;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.r0.a0.d;
import d.a.r0.r.q.b2;
import d.a.r0.r.q.e0;
import d.a.r0.r.q.m0;
import d.a.r0.r.q.w0;
import d.a.r0.r.q.x1;
import d.a.r0.r.s.a;
import d.a.r0.r.s.b;
import d.a.r0.r.s.l;
import d.a.s0.h.f;
import d.a.s0.h.i;
import d.a.s0.h2.k.e.f0;
import d.a.s0.h2.k.e.g0;
import d.a.s0.h2.k.e.x0;
import d.a.s0.u0.v0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.ForumToolPerm;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.c.k.d.a A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public d.a.r0.r.b0.a J;
    public d.a.s0.h3.h0.e K;
    public boolean L;
    public final View.OnLongClickListener M;
    public l.e N;
    public boolean O;
    public final b.c P;

    /* renamed from: a  reason: collision with root package name */
    public VideoPbFragment f61036a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.r0.r.s.j f61037b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.r0.r.s.l f61038c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.r0.r.s.j f61039d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.r.s.a f61040e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f61041f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f61042g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.r0.r.s.e f61043h;

    /* renamed from: i  reason: collision with root package name */
    public View f61044i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public d.a.r0.r.s.j q;
    public d.a.r0.r.f0.a r;
    public d.a.r0.r.s.b s;
    public AlertDialog t;
    public f0 u;
    public d.a.s0.h.f v;
    public d.a.s0.h.i w;
    public d.a.s0.h2.k.f.a x;
    public PbFragment.s2 y;
    public x0 z;

    /* renamed from: d.a.s0.h2.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1484a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61045a;

        public C1484a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61045a = aVar;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f61045a.A == null || TextUtils.isEmpty(this.f61045a.B)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f61045a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f61045a.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f54736a = this.f61045a.B;
                        String str = "";
                        if (this.f61045a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f61045a.C.memeInfo.pck_id;
                        }
                        aVar.f54737b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f61045a.F == null) {
                        this.f61045a.F = new PermissionJudgePolicy();
                    }
                    this.f61045a.F.clearRequestPermissionList();
                    this.f61045a.F.appendRequestPermission(this.f61045a.f61036a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (this.f61045a.F.startRequestPermission(this.f61045a.f61036a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f61045a.z == null) {
                        a aVar2 = this.f61045a;
                        aVar2.z = new x0(aVar2.f61036a.getPageContext());
                    }
                    this.f61045a.z.b(this.f61045a.B, this.f61045a.A.n());
                }
                this.f61045a.A = null;
                this.f61045a.B = null;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61046e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61046e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f61046e.f61036a.N2(aVar, null);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements f.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f61047a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f61048b;

        public d(a aVar, d.a.r0.r.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61048b = aVar;
            this.f61047a = aVar2;
        }

        @Override // d.a.s0.h.f.g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f61048b.f61036a.N2(this.f61047a, jSONArray);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class e implements i.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f61049a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f61050b;

        public e(a aVar, d.a.r0.r.s.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61050b = aVar;
            this.f61049a = aVar2;
        }

        @Override // d.a.s0.h.i.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f61050b.f61036a.N2(this.f61049a, jSONArray);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f61051e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f61052f;

        public f(a aVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61052f = aVar;
            this.f61051e = z;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f61052f.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f61052f.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f61052f.y != null) {
                            this.f61052f.y.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f61052f.T(this.f61051e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61053a;

        public g(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61053a = aVar;
        }

        @Override // d.a.r0.r.s.b.c
        public void a(d.a.r0.r.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f61053a.f61036a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    a aVar = this.f61053a;
                    aVar.H = aVar.H.trim();
                    UtilHelper.callPhone(this.f61053a.f61036a.getPageContext().getPageActivity(), this.f61053a.H);
                    new d.a.s0.h2.k.e.d(this.f61053a.f61036a.y().T0(), this.f61053a.H, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f61053a.f61036a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    a aVar2 = this.f61053a;
                    aVar2.H = aVar2.H.trim();
                    UtilHelper.smsPhone(this.f61053a.f61036a.getPageContext().getPageActivity(), this.f61053a.H);
                    new d.a.s0.h2.k.e.d(this.f61053a.f61036a.y().T0(), this.f61053a.H, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    a aVar3 = this.f61053a;
                    aVar3.H = aVar3.H.trim();
                    UtilHelper.startBaiDuBar(this.f61053a.f61036a.getPageContext().getPageActivity(), this.f61053a.H);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class h implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.j f61054e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f61055f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f61056g;

        public h(a aVar, d.a.r0.r.s.j jVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, jVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61056g = aVar;
            this.f61054e = jVar;
            this.f61055f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.f61056g.f61036a.y().Q0() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // d.a.r0.r.s.l.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            boolean b2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, lVar, i2, view) != null) {
                return;
            }
            this.f61054e.dismiss();
            int i3 = 3;
            if (this.f61056g.f61036a.y().Q0() != 1 || i2 != 1) {
                if (this.f61056g.f61036a.y().Q0() == 2 && i2 == 0) {
                    i3 = 1;
                } else if (this.f61056g.f61036a.y().Q0() == 3 && i2 != 2) {
                    i3 = 2;
                } else if (i2 == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f61055f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f61056g.f61036a.y().D0().f60142f != null && this.f61056g.f61036a.y().D0().f60142f.size() > i2) {
                    i2 = this.f61056g.f61036a.y().D0().f60142f.get(i2).sort_type.intValue();
                }
                b2 = this.f61056g.f61036a.y().b2(i2);
                this.f61055f.setTag(Integer.valueOf(this.f61056g.f61036a.y().P0()));
                if (b2) {
                    return;
                }
                this.f61056g.f61036a.s4(true);
                return;
            }
            i3 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f61055f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
            if (this.f61056g.f61036a.y().D0().f60142f != null) {
                i2 = this.f61056g.f61036a.y().D0().f60142f.get(i2).sort_type.intValue();
            }
            b2 = this.f61056g.f61036a.y().b2(i2);
            this.f61055f.setTag(Integer.valueOf(this.f61056g.f61036a.y().P0()));
            if (b2) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f61057e;

        public i(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61057e = metaData;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f61057e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f61058e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f61059f;

        public j(a aVar, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61059f = aVar;
            this.f61058e = metaData;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f61058e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                if (this.f61059f.f61036a.U2() != null) {
                    this.f61059f.f61036a.U2().m(!this.f61058e.hadConcerned(), this.f61058e.getPortrait(), this.f61058e.getUserId(), this.f61058e.isGod(), "6", this.f61059f.f61036a.getPageContext().getUniqueId(), this.f61059f.f61036a.y().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61060e;

        public k(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61060e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f61060e.t == null) {
                return;
            }
            d.a.c.e.m.g.a(this.f61060e.t, this.f61060e.f61036a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes9.dex */
    public class l implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class m implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f61061e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f61062f;

        public m(a aVar, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, userMuteAddAndDelCustomMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61062f = aVar;
            this.f61061e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f61062f.v0();
                MessageManager.getInstance().sendMessage(this.f61061e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class n implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public n(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class o implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f61063e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f61064f;

        public o(a aVar, b.c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61064f = aVar;
            this.f61063e = cVar;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f61064f.f61039d.dismiss();
                this.f61063e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class p implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61065e;

        public p(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61065e = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f61065e.n = (String) compoundButton.getTag();
                if (this.f61065e.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f61065e.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f61065e.n != null && !str.equals(this.f61065e.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61066e;

        public q(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61066e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f61066e.f61042g instanceof Dialog)) {
                d.a.c.e.m.g.b(this.f61066e.f61042g, this.f61066e.f61036a.getPageContext());
            }
        }
    }

    /* loaded from: classes9.dex */
    public class r implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61067e;

        public r(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61067e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f61067e.E(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class s implements PbFragment.s2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f61068a;

        public s(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61068a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.s2
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!d.a.c.e.p.j.z()) {
                    this.f61068a.f61036a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f61068a.f61036a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f61068a.f61036a.getPageContext().getPageActivity(), this.f61068a.f61036a.y().D0().m().getId(), this.f61068a.f61036a.y().D0().m().getName(), this.f61068a.f61036a.y().D0().N().c0(), String.valueOf(this.f61068a.f61036a.y().D0().T().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class t implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61069e;

        public t(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61069e = aVar;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f61069e.f61037b != null) {
                    this.f61069e.f61037b.dismiss();
                }
                this.f61069e.G0(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f61069e.l0(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f61069e.l0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        this.f61069e.l0(view4);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        this.f61069e.l0(view5);
                        AgreeView agreeView2 = (AgreeView) view5;
                        if (agreeView2 == null || agreeView2.getImgAgree() == null) {
                            return;
                        }
                        agreeView2.getImgAgree().performClick();
                        return;
                    case 0:
                    default:
                        return;
                    case 1:
                        if (this.f61069e.A == null || TextUtils.isEmpty(this.f61069e.B)) {
                            return;
                        }
                        if (this.f61069e.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f61069e.B));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f54736a = this.f61069e.B;
                            String str = "";
                            if (this.f61069e.C.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f61069e.C.memeInfo.pck_id;
                            }
                            aVar.f54737b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f61069e.A = null;
                        this.f61069e.B = null;
                        return;
                    case 2:
                        if (this.f61069e.A == null || TextUtils.isEmpty(this.f61069e.B)) {
                            return;
                        }
                        if (this.f61069e.F == null) {
                            this.f61069e.F = new PermissionJudgePolicy();
                        }
                        this.f61069e.F.clearRequestPermissionList();
                        this.f61069e.F.appendRequestPermission(this.f61069e.f61036a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f61069e.F.startRequestPermission(this.f61069e.f61036a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f61069e.z == null) {
                            a aVar2 = this.f61069e;
                            aVar2.z = new x0(aVar2.f61036a.getPageContext());
                        }
                        this.f61069e.z.b(this.f61069e.B, this.f61069e.A.n());
                        this.f61069e.A = null;
                        this.f61069e.B = null;
                        return;
                    case 3:
                        a aVar3 = this.f61069e;
                        PostData postData = aVar3.G;
                        if (postData != null) {
                            postData.h0(aVar3.f61036a.getPageContext().getPageActivity());
                            this.f61069e.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f61069e.f61036a.checkUpIsLogin()) {
                            this.f61069e.c0(view);
                            if (this.f61069e.f61036a.y().D0().N() == null || this.f61069e.f61036a.y().D0().N().H() == null || this.f61069e.f61036a.y().D0().N().H().getUserId() == null || this.f61069e.f61036a.f3() == null) {
                                return;
                            }
                            a aVar4 = this.f61069e;
                            int S = aVar4.S(aVar4.f61036a.y().D0());
                            b2 N = this.f61069e.f61036a.y().D0().N();
                            if (N.E1()) {
                                i3 = 2;
                            } else if (N.H1()) {
                                i3 = 3;
                            } else if (!N.F1()) {
                                i3 = N.G1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f61069e.f61036a.y().T0()).param("obj_locate", 2).param("obj_id", this.f61069e.f61036a.y().D0().N().H().getUserId()).param("obj_type", !this.f61069e.f61036a.f3().e()).param("obj_source", S).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!d.a.c.e.p.j.z()) {
                            this.f61069e.f61036a.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f61069e.U((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f61069e.B(sparseArray2);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    case 6:
                        SparseArray sparseArray3 = (SparseArray) view.getTag();
                        if (sparseArray3 != null && (sparseArray3.get(R.id.tag_del_post_type) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_id) instanceof String) && (sparseArray3.get(R.id.tag_manage_user_identity) instanceof Integer) && (sparseArray3.get(R.id.tag_del_post_is_self) instanceof Boolean)) {
                            boolean booleanValue = ((Boolean) sparseArray3.get(R.id.tag_del_post_is_self)).booleanValue();
                            int intValue = ((Integer) sparseArray3.get(R.id.tag_manage_user_identity)).intValue();
                            boolean booleanValue2 = ((Boolean) sparseArray3.get(R.id.tag_has_sub_post)).booleanValue();
                            VideoPbFragment videoPbFragment = this.f61069e.f61036a;
                            if (videoPbFragment == null || videoPbFragment.z() == null) {
                                return;
                            }
                            boolean isHost = this.f61069e.f61036a.z().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f61069e.p0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f61069e.h0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f61069e.p0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f61069e.f0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!d.a.c.e.p.j.z()) {
                            this.f61069e.f61036a.showToast(R.string.network_not_available);
                            return;
                        }
                        SparseArray<Object> sparseArray4 = (SparseArray) view.getTag();
                        if (sparseArray4 == null) {
                            return;
                        }
                        boolean booleanValue3 = ((Boolean) sparseArray4.get(R.id.tag_should_manage_visible)).booleanValue();
                        boolean booleanValue4 = ((Boolean) sparseArray4.get(R.id.tag_should_delete_visible)).booleanValue();
                        boolean booleanValue5 = ((Boolean) sparseArray4.get(R.id.tag_user_mute_visible)).booleanValue();
                        if (!booleanValue3) {
                            if (booleanValue4) {
                                this.f61069e.f0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f61069e.B(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f61069e.j0(view);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.f61069e.f61036a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            d.a.r0.i0.c f2 = TbPageExtraHelper.f(view);
                            if (f2 != null) {
                                postData2.q().objSource = f2.a();
                            }
                            this.f61069e.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        VideoPbFragment videoPbFragment2 = this.f61069e.f61036a;
                        if (videoPbFragment2 == null || videoPbFragment2.y() == null || this.f61069e.f61036a.y().D0() == null || !ViewHelper.checkUpIsLogin(this.f61069e.f61036a.getContext()) || this.f61069e.f61036a.z() == null) {
                            return;
                        }
                        this.f61069e.f61036a.z().showBlockDialog(d.a.s0.r3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f61070e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f61071f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f61072g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f61073h;

        public u(a aVar, SparseArray sparseArray, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61073h = aVar;
            this.f61070e = sparseArray;
            this.f61071f = i2;
            this.f61072g = z;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f61073h.f61036a.O2(((Integer) this.f61070e.get(R.id.tag_del_post_type)).intValue(), (String) this.f61070e.get(R.id.tag_del_post_id), this.f61071f, this.f61072g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class v implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public v(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class w implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f61074e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f61075f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f61076g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f61077h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f61078i;

        public w(a aVar, SparseArray sparseArray, boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, sparseArray, Boolean.valueOf(z), str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61078i = aVar;
            this.f61074e = sparseArray;
            this.f61075f = z;
            this.f61076g = str;
            this.f61077h = str2;
        }

        @Override // d.a.r0.r.s.l.e
        public void onItemClick(d.a.r0.r.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f61078i.f61037b != null) {
                    this.f61078i.f61037b.dismiss();
                }
                if (i2 == 0) {
                    this.f61078i.f0(((Integer) this.f61074e.get(R.id.tag_del_post_type)).intValue(), (String) this.f61074e.get(R.id.tag_del_post_id), ((Integer) this.f61074e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f61074e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f61074e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f61074e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f61074e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f61075f, this.f61076g, str, str2, str3, 1, this.f61077h, this.f61078i.D);
                    userMuteAddAndDelCustomMessage.setTag(this.f61078i.D);
                    this.f61078i.F0(this.f61075f, userMuteAddAndDelCustomMessage, this.f61077h, str, (String) this.f61074e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f61079e;

        public x(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f61079e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f61079e.f61036a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class y implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public y(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(590333946, "Ld/a/s0/h2/o/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(590333946, "Ld/a/s0/h2/o/g/a;");
        }
    }

    public a(VideoPbFragment videoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {videoPbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f61039d = null;
        this.f61040e = null;
        this.f61041f = null;
        this.f61042g = null;
        this.f61043h = null;
        this.f61044i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.G = null;
        this.L = d.a.r0.b.d.W();
        this.M = new r(this);
        this.N = new t(this);
        this.P = new C1484a(this);
        this.f61036a = videoPbFragment;
        this.D = videoPbFragment.getUniqueId();
        d.a.s0.h2.k.f.a aVar = new d.a.s0.h2.k.f.a(this.f61036a.getContext());
        this.x = aVar;
        aVar.a(this.f61036a.getUniqueId());
        this.y = new s(this);
    }

    public void A0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onItemClickListener) == null) {
            d.a.r0.r.s.e eVar = this.f61043h;
            if (eVar != null) {
                eVar.d();
                this.f61043h = null;
            }
            if (this.f61036a.y() == null) {
                return;
            }
            ArrayList<d.a.r0.r.s.n> arrayList = new ArrayList<>();
            arrayList.add(new d.a.r0.r.s.n(this.f61036a.getContext().getString(R.string.all_person), "", this.f61036a.y().M0() == 1, Integer.toString(1)));
            arrayList.add(new d.a.r0.r.s.n(this.f61036a.getContext().getString(R.string.my_fans), "", this.f61036a.y().M0() == 2, Integer.toString(5)));
            arrayList.add(new d.a.r0.r.s.n(this.f61036a.getContext().getString(R.string.my_attentions), "", this.f61036a.y().M0() == 3, Integer.toString(6)));
            arrayList.add(new d.a.r0.r.s.n(this.f61036a.getContext().getString(R.string.myself_only), "", this.f61036a.y().M0() == 4, Integer.toString(7)));
            d.a.r0.r.s.e eVar2 = new d.a.r0.r.s.e(this.f61036a.getPageContext());
            eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.f61043h = eVar2;
            eVar2.k(arrayList, onItemClickListener);
            eVar2.c();
            this.f61043h.n();
        }
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            v0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = d.a.c.e.m.b.f(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = d.a.c.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g0Var) == null) || this.f61036a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        VideoPbFragment videoPbFragment = this.f61036a;
        this.u = new f0(videoPbFragment, videoPbFragment.G1);
        AlertDialog create = new AlertDialog.Builder(this.f61036a.getContext(), R.style.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        d.a.c.e.m.g.i(this.t, this.f61036a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.s());
        this.u.J(g0Var == null ? false : g0Var.f60530a);
        this.u.x(g0Var == null ? false : g0Var.f60534e);
        this.u.B(g0Var == null ? false : g0Var.f60538i);
        this.u.y(g0Var == null ? false : g0Var.f60535f);
        this.u.L(g0Var != null ? g0Var.f60532c : true);
        this.u.I(g0Var == null ? false : g0Var.k);
        if (g0Var == null) {
            this.u.G(false, false);
            this.u.F(false, false);
        } else {
            this.u.G(g0Var.f60536g, g0Var.q);
            this.u.F(g0Var.f60537h, g0Var.p);
        }
        boolean z = g0Var == null ? false : g0Var.o;
        boolean z2 = g0Var == null ? false : g0Var.m;
        boolean z3 = g0Var == null ? false : g0Var.f60533d;
        boolean z4 = g0Var == null ? false : g0Var.f60531b;
        boolean z5 = g0Var == null ? false : g0Var.n;
        boolean z6 = g0Var == null ? false : g0Var.j;
        boolean z7 = g0Var == null ? false : g0Var.l;
        this.u.z(z3, z2);
        this.u.K(z4, z);
        this.u.H(z6, z5);
        this.u.O(z7);
        if (g0Var != null) {
            f0 f0Var = this.u;
            boolean z8 = g0Var.r;
            f0Var.u = z8;
            if (z8) {
                f0Var.f().setText(R.string.report_text);
                this.u.y(false);
            }
        }
        this.u.w(g0Var != null ? g0Var.s : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.f61036a.y() != null && this.f61036a.y().D0() != null && this.f61036a.y().D0().P() != null && this.f61036a.y().D0().P().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(R.string.have_called_fans_short);
        }
        H0();
    }

    public final void C(AgreeData agreeData) {
        VideoPbFragment videoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new d.a.r0.r.b0.a();
        }
        if (this.K == null) {
            d.a.s0.h3.h0.e eVar = new d.a.s0.h3.h0.e();
            this.K = eVar;
            eVar.f61215a = this.f61036a.getUniqueId();
        }
        d.a.r0.r.q.f fVar = new d.a.r0.r.q.f();
        fVar.f55932b = 5;
        fVar.f55938h = 8;
        fVar.f55937g = 2;
        VideoPbFragment videoPbFragment2 = this.f61036a;
        if (videoPbFragment2 != null && videoPbFragment2.y() != null) {
            fVar.f55936f = this.f61036a.y().C0();
        }
        fVar.f55931a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f55939i = 0;
                this.J.c(agreeData, i2, this.f61036a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                videoPbFragment = this.f61036a;
                if (videoPbFragment != null || videoPbFragment.y() == null || this.f61036a.y().D0() == null) {
                    return;
                }
                this.J.b(this.f61036a.z(), fVar, agreeData, this.f61036a.y().D0().N());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f55939i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f55939i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.f61036a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        videoPbFragment = this.f61036a;
        if (videoPbFragment != null) {
        }
    }

    public final void C0(d.a.r0.r.s.a aVar, int i2) {
        VideoPbFragment videoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, aVar, i2) == null) || (videoPbFragment = this.f61036a) == null || aVar == null) {
            return;
        }
        if (this.v == null && videoPbFragment.getView() != null) {
            this.v = new d.a.s0.h.f(this.f61036a.getPageContext(), this.f61036a.getView());
        }
        AntiData L = L();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        this.v.x(new String[]{this.f61036a.getString(R.string.delete_thread_reason_1), this.f61036a.getString(R.string.delete_thread_reason_2), this.f61036a.getString(R.string.delete_thread_reason_3), this.f61036a.getString(R.string.delete_thread_reason_4), this.f61036a.getString(R.string.delete_thread_reason_5)});
        this.v.w(w0Var);
        this.v.z((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.y(new d(this, aVar));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.f61036a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.c.e.p.l.g(pageActivity, R.dimen.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void D0(View view) {
        VideoPbFragment videoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || (videoPbFragment = this.f61036a) == null || videoPbFragment.y() == null) {
            return;
        }
        d.a.r0.r.s.j jVar = new d.a.r0.r.s.j(this.f61036a.getPageContext());
        if (this.f61036a.y().D0().f60142f == null || this.f61036a.y().D0().f60142f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
        } else {
            strArr = new String[this.f61036a.y().D0().f60142f.size()];
            for (int i2 = 0; i2 < this.f61036a.y().D0().f60142f.size(); i2++) {
                strArr[i2] = this.f61036a.y().D0().f60142f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
            }
        }
        jVar.i(null, strArr, new h(this, jVar, view));
        jVar.l();
    }

    public final boolean E(View view) {
        InterceptResult invokeL;
        SparseArray sparseArray;
        boolean z;
        boolean z2;
        List<d.a.r0.r.s.h> b2;
        d.a.r0.r.s.h hVar;
        d.a.r0.r.s.h hVar2;
        d.a.r0.r.s.h hVar3;
        d.a.r0.r.s.h hVar4;
        d.a.c.k.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            VideoPbFragment videoPbFragment = this.f61036a;
            if (videoPbFragment == null || !videoPbFragment.isAdded()) {
                return true;
            }
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null) {
                if (Y(view)) {
                    if (view instanceof TbImageView) {
                        TbImageView tbImageView = (TbImageView) view;
                        this.A = tbImageView.getBdImage();
                        String url = tbImageView.getUrl();
                        this.B = url;
                        if (this.A == null || TextUtils.isEmpty(url)) {
                            return true;
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.C = null;
                        }
                    } else if (view instanceof GifView) {
                        GifView gifView = (GifView) view;
                        if (gifView.getBdImage() == null) {
                            return true;
                        }
                        this.A = gifView.getBdImage();
                        if (!TextUtils.isEmpty(gifView.getBdImage().q())) {
                            this.B = gifView.getBdImage().q();
                        }
                        if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                            this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                        } else {
                            this.C = null;
                        }
                    } else if (view instanceof TbMemeImageView) {
                        TbMemeImageView tbMemeImageView = (TbMemeImageView) view;
                        if (tbMemeImageView.getBdImage() != null) {
                            this.A = tbMemeImageView.getBdImage();
                            if (!TextUtils.isEmpty(tbMemeImageView.getBdImage().q())) {
                                this.B = tbMemeImageView.getBdImage().q();
                            }
                            if (view.getTag(R.id.tag_rich_text_meme_info) != null && (view.getTag(R.id.tag_rich_text_meme_info) instanceof TbRichTextImageInfo)) {
                                this.C = (TbRichTextMemeInfo) view.getTag(R.id.tag_rich_text_meme_info);
                            } else {
                                this.C = null;
                            }
                        }
                    }
                    if (view.getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent()).getTag();
                        } catch (ClassCastException e3) {
                            e3.printStackTrace();
                        }
                    } else if (view.getParent().getParent() instanceof TbRichTextView) {
                        try {
                            sparseArray2 = (SparseArray) ((TbRichTextView) view.getParent().getParent()).getTag();
                        } catch (ClassCastException e4) {
                            e4.printStackTrace();
                        }
                    } else {
                        z0(this.P, this.A.t());
                    }
                    sparseArray = sparseArray2;
                }
                if (sparseArray == null) {
                    return true;
                }
            }
            PostData postData = (PostData) sparseArray.get(R.id.tag_clip_board);
            this.G = postData;
            if (postData == null || this.f61036a.f3() == null) {
                return true;
            }
            boolean z3 = this.f61036a.f3().e() && this.G.E() != null && this.G.E().equals(this.f61036a.y().y0());
            boolean z4 = this.f61036a.y().D0() != null && this.f61036a.y().D0().e0();
            if (this.f61038c == null) {
                d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(this.f61036a.getContext());
                this.f61038c = lVar;
                lVar.n(this.N);
            }
            ArrayList arrayList = new ArrayList();
            if (view == null || sparseArray == null) {
                return true;
            }
            boolean z5 = Y(view) && !z4;
            boolean z6 = (!Y(view) || (aVar = this.A) == null || aVar.t()) ? false : true;
            boolean booleanValue = sparseArray.get(R.id.tag_is_subpb) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_is_subpb)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue6 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (z5) {
                z2 = booleanValue6;
                z = booleanValue5;
                arrayList.add(new d.a.r0.r.s.h(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.f61038c));
            } else {
                z = booleanValue5;
                z2 = booleanValue6;
            }
            if (z6) {
                arrayList.add(new d.a.r0.r.s.h(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.f61038c));
            }
            if (!z5 && !z6) {
                d.a.r0.r.s.h hVar5 = new d.a.r0.r.s.h(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.f61038c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.G);
                hVar5.f56178d.setTag(sparseArray3);
                arrayList.add(hVar5);
            }
            if (!booleanValue && !z4) {
                if (z3) {
                    hVar4 = new d.a.r0.r.s.h(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.f61038c);
                } else {
                    hVar4 = new d.a.r0.r.s.h(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.f61038c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.G);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                hVar4.f56178d.setTag(sparseArray4);
                arrayList.add(hVar4);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    d.a.r0.r.s.h hVar6 = new d.a.r0.r.s.h(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.f61038c);
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i2 = R.id.tag_is_mem;
                    sparseArray5.put(i2, sparseArray.get(i2));
                    int i3 = R.id.tag_user_mute_mute_userid;
                    sparseArray5.put(i3, sparseArray.get(i3));
                    int i4 = R.id.tag_user_mute_mute_username;
                    sparseArray5.put(i4, sparseArray.get(i4));
                    int i5 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray5.put(i5, sparseArray.get(i5));
                    int i6 = R.id.tag_user_mute_post_id;
                    sparseArray5.put(i6, sparseArray.get(i6));
                    int i7 = R.id.tag_user_mute_thread_id;
                    sparseArray5.put(i7, sparseArray.get(i7));
                    int i8 = R.id.tag_del_post_is_self;
                    sparseArray5.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_del_post_type;
                    sparseArray5.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_del_post_id;
                    sparseArray5.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_manage_user_identity;
                    sparseArray5.put(i11, sparseArray.get(i11));
                    hVar6.f56178d.setTag(sparseArray5);
                    arrayList.add(hVar6);
                } else {
                    if ((a0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z4) {
                        d.a.r0.r.s.h hVar7 = new d.a.r0.r.s.h(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f61038c);
                        hVar7.f56178d.setTag(str);
                        arrayList.add(hVar7);
                    }
                }
                if (booleanValue4) {
                    SparseArray sparseArray6 = new SparseArray();
                    sparseArray6.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    int i12 = R.id.tag_manage_user_identity;
                    sparseArray6.put(i12, sparseArray.get(i12));
                    int i13 = R.id.tag_forbid_user_name;
                    sparseArray6.put(i13, sparseArray.get(i13));
                    int i14 = R.id.tag_forbid_user_name_show;
                    sparseArray6.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_forbid_user_portrait;
                    sparseArray6.put(i15, sparseArray.get(i15));
                    sparseArray6.put(R.id.tag_forbid_user_post_id, str);
                    if (!X() && z) {
                        sparseArray6.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i16 = R.id.tag_is_mem;
                        sparseArray6.put(i16, sparseArray.get(i16));
                        int i17 = R.id.tag_user_mute_mute_userid;
                        sparseArray6.put(i17, sparseArray.get(i17));
                        int i18 = R.id.tag_user_mute_mute_username;
                        sparseArray6.put(i18, sparseArray.get(i18));
                        int i19 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray6.put(i19, sparseArray.get(i19));
                        int i20 = R.id.tag_user_mute_post_id;
                        sparseArray6.put(i20, sparseArray.get(i20));
                        int i21 = R.id.tag_user_mute_thread_id;
                        sparseArray6.put(i21, sparseArray.get(i21));
                    } else {
                        sparseArray6.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (z2) {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray6.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                        int i22 = R.id.tag_del_post_id;
                        sparseArray6.put(i22, sparseArray.get(i22));
                        int i23 = R.id.tag_del_post_type;
                        sparseArray6.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_has_sub_post;
                        sparseArray6.put(i24, sparseArray.get(i24));
                        hVar2 = new d.a.r0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f61038c);
                        hVar2.f56178d.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.a.r0.r.s.h(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.f61038c);
                    hVar.f56178d.setTag(sparseArray6);
                } else if (z2) {
                    SparseArray sparseArray7 = new SparseArray();
                    sparseArray7.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray7.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray7.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    int i25 = R.id.tag_manage_user_identity;
                    sparseArray7.put(i25, sparseArray.get(i25));
                    sparseArray7.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue2));
                    int i26 = R.id.tag_del_post_id;
                    sparseArray7.put(i26, sparseArray.get(i26));
                    int i27 = R.id.tag_del_post_type;
                    sparseArray7.put(i27, sparseArray.get(i27));
                    int i28 = R.id.tag_has_sub_post;
                    sparseArray7.put(i28, sparseArray.get(i28));
                    if (this.f61036a.y().D0().U() == 1002 && !booleanValue2) {
                        hVar3 = new d.a.r0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f61038c);
                    } else {
                        hVar3 = new d.a.r0.r.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f61038c);
                    }
                    hVar3.f56178d.setTag(sparseArray7);
                    hVar2 = hVar3;
                    hVar = null;
                } else {
                    hVar = null;
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
                d.a.s0.h2.k.e.f1.a.a(arrayList, this.f61038c, this.G, this.f61036a.y());
            }
            if (d.a.r0.b.d.z()) {
                b2 = d.a.s0.h2.k.e.f1.a.c(arrayList, this.G.q(), sparseArray, this.f61038c);
            } else {
                b2 = d.a.s0.h2.k.e.f1.a.b(arrayList, this.G.q(), sparseArray, this.f61038c);
            }
            d.a.s0.h2.k.e.f1.a.k(b2, this.O);
            d.a.s0.h2.k.e.f1.a.e(b2);
            this.f61038c.o(d.a.s0.h2.k.e.f1.a.f(this.G));
            if (d.a.r0.b.d.z()) {
                this.f61038c.l(b2, false);
            } else {
                this.f61038c.l(b2, true);
            }
            d.a.r0.r.s.j jVar = new d.a.r0.r.s.j(this.f61036a.getPageContext(), this.f61038c);
            this.f61037b = jVar;
            jVar.l();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.f61036a.y().T0()).param("fid", this.f61036a.y().getForumId()).param("uid", this.f61036a.y().D0().N().H().getUserId()).param("post_id", this.f61036a.y().w()).param("obj_source", booleanValue ? 2 : 1));
            return true;
        }
        return invokeL.booleanValue;
    }

    public void E0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (str == null) {
                str = "";
            }
            VideoPbFragment videoPbFragment = this.f61036a;
            if (videoPbFragment == null || videoPbFragment.getPageContext() == null) {
                return;
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f61036a.getPageContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new l(this));
            aVar.create(this.f61036a.getPageContext()).show();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.f61036a.s3();
            d.a.r0.r.s.j jVar = this.f61037b;
            if (jVar != null) {
                jVar.dismiss();
            }
            this.f61036a.t3();
            K();
        }
    }

    public final void F0(boolean z, UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), userMuteAddAndDelCustomMessage, str, str2, str3}) == null) {
            if (z) {
                v0();
                MessageManager.getInstance().sendMessage(userMuteAddAndDelCustomMessage);
                return;
            }
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f61036a.getBaseFragmentActivity());
            if (d.a.c.e.p.k.isEmpty(str)) {
                aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new m(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new n(this));
            aVar.create(this.f61036a.getPageContext()).show();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.f61036a.s3();
            d.a.r0.r.s.j jVar = this.f61037b;
            if (jVar != null) {
                jVar.dismiss();
            }
            K();
        }
    }

    public final void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.f61036a.y().T0()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.a.s0.h2.k.e.f1.a.m(i2))));
        }
    }

    public void H() {
        d.a.r0.r.s.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (jVar = this.f61037b) == null) {
            return;
        }
        jVar.dismiss();
    }

    public final void H0() {
        f0 f0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (f0Var = this.u) == null) {
            return;
        }
        f0Var.v();
    }

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            if (this.I == null) {
                this.I = new k(this);
            }
            d.a.c.e.m.e.a().postDelayed(this.I, 100L);
        }
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        d.a.c.e.m.g.a(alertDialog, this.f61036a.getPageContext().getPageActivity());
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d.a.r0.r.s.a aVar = this.f61040e;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.f61041f;
            if (dialog != null) {
                d.a.c.e.m.g.b(dialog, this.f61036a.getPageContext());
            }
            Dialog dialog2 = this.f61042g;
            if (dialog2 != null) {
                d.a.c.e.m.g.b(dialog2, this.f61036a.getPageContext());
            }
            d.a.r0.r.s.j jVar = this.q;
            if (jVar != null) {
                jVar.dismiss();
            }
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f61036a.y() == null || this.f61036a.y().D0() == null) {
                return null;
            }
            return this.f61036a.y().D0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            View view = this.f61044i;
            if (view != null) {
                return view.findViewById(R.id.dialog_button_ok);
            }
            return null;
        }
        return (View) invokeV.objValue;
    }

    public String N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.n : (String) invokeV.objValue;
    }

    public Object O() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.E : invokeV.objValue;
    }

    public View.OnLongClickListener P() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.M : (View.OnLongClickListener) invokeV.objValue;
    }

    public f0 Q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.u : (f0) invokeV.objValue;
    }

    public d.a.r0.r.s.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.s : (d.a.r0.r.s.b) invokeV.objValue;
    }

    public int S(d.a.s0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return 0;
            }
            if (eVar.N().j1() == 0) {
                return 1;
            }
            if (eVar.N().j1() == 54) {
                return 2;
            }
            return eVar.N().j1() == 40 ? 3 : 4;
        }
        return invokeL.intValue;
    }

    public void T(boolean z, String str, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048602, this, new Object[]{Boolean.valueOf(z), str, sparseArray}) == null) {
            String str2 = sparseArray.get(R.id.tag_user_mute_mute_username) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_username) : "";
            String str3 = sparseArray.get(R.id.tag_user_mute_thread_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_thread_id) : "";
            String str4 = sparseArray.get(R.id.tag_user_mute_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_post_id) : "";
            String str5 = sparseArray.get(R.id.tag_user_mute_msg) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_msg) : "";
            String str6 = sparseArray.get(R.id.tag_user_mute_mute_nameshow) instanceof String ? (String) sparseArray.get(R.id.tag_user_mute_mute_nameshow) : "";
            UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
            userMuteAddAndDelCustomMessage.setData(z, str, str2, str3, str4, 1, str5, this.D);
            userMuteAddAndDelCustomMessage.setTag(this.D);
            F0(z, userMuteAddAndDelCustomMessage, str5, str2, str6);
        }
    }

    public void U(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, str) == null) {
            if (this.f61036a.y() != null && this.f61036a.y().D0() != null && this.f61036a.y().D0().e0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.f61036a.y().T0(), str);
                b2 N = this.f61036a.y().D0().N();
                if (N.E1()) {
                    format = format + "&channelid=33833";
                } else if (N.J1()) {
                    format = format + "&channelid=33842";
                } else if (N.H1()) {
                    format = format + "&channelid=33840";
                }
                b0(format);
                return;
            }
            this.x.i(str);
        }
    }

    public void V() {
        d.a.r0.r.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.s == null) {
            this.s = new d.a.r0.r.s.b(this.f61036a.getPageContext().getPageActivity());
            String[] strArr = {this.f61036a.getPageContext().getString(R.string.call_phone), this.f61036a.getPageContext().getString(R.string.sms_phone), this.f61036a.getPageContext().getString(R.string.search_in_baidu)};
            d.a.r0.r.s.b bVar = this.s;
            bVar.j(strArr, new g(this));
            bVar.g(b.C1266b.f56148a);
            bVar.h(17);
            bVar.c(this.f61036a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? d.a.s0.h2.k.e.f1.a.h(this.f61036a.y()) : invokeV.booleanValue;
    }

    public boolean Y(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, view)) == null) ? (view instanceof TbImageView) || (view instanceof TbMemeImageView) || (view instanceof GifView) : invokeL.booleanValue;
    }

    public boolean Z(int i2) {
        InterceptResult invokeI;
        List<ForumToolPerm> forumToolAuth;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048608, this, i2)) == null) {
            if (i2 != 1) {
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.f61036a.y().D0().T() != null && (forumToolAuth = this.f61036a.y().D0().T().getForumToolAuth()) != null) {
                    for (int i3 = 0; i3 < forumToolAuth.size(); i3++) {
                        ForumToolPerm forumToolPerm = forumToolAuth.get(i3);
                        if (forumToolPerm != null && forumToolPerm.perm.longValue() == 1) {
                            return true;
                        }
                    }
                }
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    public final boolean a0(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048609, this, z)) == null) {
            if (this.f61036a.y() != null && this.f61036a.y().D0() != null) {
                return ((this.f61036a.y().D0().U() != 0) || this.f61036a.y().D0().N() == null || this.f61036a.y().D0().N().H() == null || TextUtils.equals(this.f61036a.y().D0().N().H().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f61036a.getContext(), "", str, true);
            tbWebViewActivityConfig.setFixTitle(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
        }
    }

    public final void c0(View view) {
        SparseArray sparseArray;
        PostData postData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, view) == null) {
            try {
                sparseArray = (SparseArray) view.getTag();
            } catch (ClassCastException e2) {
                e2.printStackTrace();
                sparseArray = null;
            }
            if (sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
                return;
            }
            d0(postData);
        }
    }

    public void d0(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048612, this, postData) == null) || postData == null) {
            return;
        }
        boolean z = false;
        if (postData.E() != null && postData.E().equals(this.f61036a.y().y0())) {
            z = true;
        }
        MarkData x0 = this.f61036a.y().x0(postData);
        if (this.f61036a.y().D0() != null && this.f61036a.y().D0().e0()) {
            VideoPbFragment videoPbFragment = this.f61036a;
            PostData Z2 = videoPbFragment.Z2(videoPbFragment.y().D0());
            if (Z2 != null) {
                x0 = this.f61036a.y().x0(Z2);
            }
        }
        if (x0 == null) {
            return;
        }
        this.f61036a.x4();
        if (this.f61036a.f3() != null) {
            this.f61036a.f3().i(x0);
            if (!z) {
                this.f61036a.f3().a();
            } else {
                this.f61036a.f3().d();
            }
        }
    }

    public void e0(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, arrayList) == null) {
            if (this.f61044i == null) {
                this.f61044i = LayoutInflater.from(this.f61036a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f61036a.getBaseFragmentActivity().getLayoutMode().j(this.f61044i);
            if (this.f61042g == null) {
                Dialog dialog = new Dialog(this.f61036a.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.f61042g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f61042g.setCancelable(true);
                this.o = (ScrollView) this.f61044i.findViewById(R.id.good_scroll);
                this.f61042g.setContentView(this.f61044i);
                WindowManager.LayoutParams attributes = this.f61042g.getWindow().getAttributes();
                attributes.width = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.f61042g.getWindow().setAttributes(attributes);
                this.p = new p(this);
                this.j = (LinearLayout) this.f61044i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.f61044i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new q(this));
                TextView textView2 = (TextView) this.f61044i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.f61036a.c3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.f61036a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(m0Var.a()), m0Var.b());
                        this.m.add(D2);
                        View view = new View(this.f61036a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.j.addView(view);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = d.a.c.e.p.l.e(this.f61036a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = d.a.c.e.p.l.e(this.f61036a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = d.a.c.e.p.l.e(this.f61036a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            d.a.c.e.m.g.j(this.f61042g, this.f61036a.getPageContext());
        }
    }

    public void f0(int i2, String str, int i3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048614, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            g0(i2, str, i3, z, null);
        }
    }

    public void g0(int i2, String str, int i3, boolean z, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048615, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2}) == null) {
            h0(i2, str, i3, z, str2, false);
        }
    }

    public void h0(int i2, String str, int i3, boolean z, String str2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3), Boolean.valueOf(z), str2, Boolean.valueOf(z2)}) == null) {
            SparseArray sparseArray = new SparseArray();
            sparseArray.put(R.id.tag_del_post_id, str);
            sparseArray.put(R.id.tag_del_post_type, Integer.valueOf(i2));
            sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(i3));
            sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z));
            sparseArray.put(Q, Integer.valueOf(R));
            int i4 = R.string.del_all_post_confirm;
            if (i3 == 1002 && !z) {
                i4 = R.string.report_post_confirm;
            }
            if (i2 == 0) {
                if (i3 == 1002 && !z) {
                    i4 = R.string.report_thread_confirm;
                } else {
                    i4 = R.string.del_thread_confirm;
                }
            }
            this.f61040e = new d.a.r0.r.s.a(this.f61036a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.f61040e.setMessageId(i4);
            } else {
                this.f61040e.setOnlyMessageShowCenter(false);
                this.f61040e.setMessage(str2);
            }
            this.f61040e.setYesButtonTag(sparseArray);
            this.f61040e.setPositiveButton(R.string.dialog_ok, new b(this));
            this.f61040e.setNegativeButton(R.string.dialog_cancel, new c(this));
            this.f61040e.setCancelable(true);
            this.f61040e.create(this.f61036a.getPageContext());
            if (z2) {
                this.f61040e.show();
            } else if (z) {
                this.f61040e.show();
            } else if (o0()) {
                d.a.s0.h.h hVar = new d.a.s0.h.h(this.f61036a.y().D0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f61036a.y().D0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f61036a.y().D0().p().has_forum_rule.intValue());
                hVar.i(this.f61036a.y().D0().m().getId(), this.f61036a.y().D0().m().getName());
                hVar.h(this.f61036a.y().D0().m().getImage_url());
                hVar.j(this.f61036a.y().D0().m().getUser_level());
                w0(this.f61040e, i2, hVar, this.f61036a.y().D0().T());
            } else {
                C0(this.f61040e, i2);
            }
        }
    }

    public void i0(SparseArray<Object> sparseArray, boolean z) {
        d.a.r0.r.s.h hVar;
        d.a.r0.r.s.h hVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, sparseArray, z) == null) {
            d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(this.f61036a.getContext());
            lVar.q(this.f61036a.getString(R.string.bar_manager));
            lVar.n(new f(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    hVar2 = new d.a.r0.r.s.h(10, this.f61036a.getString(R.string.delete_post), lVar);
                } else {
                    hVar2 = new d.a.r0.r.s.h(10, this.f61036a.getString(R.string.delete), lVar);
                }
                SparseArray sparseArray2 = new SparseArray();
                int i2 = R.id.tag_del_post_id;
                sparseArray2.put(i2, sparseArray.get(i2));
                int i3 = R.id.tag_del_post_type;
                sparseArray2.put(i3, sparseArray.get(i3));
                int i4 = R.id.tag_del_post_is_self;
                sparseArray2.put(i4, sparseArray.get(i4));
                int i5 = R.id.tag_manage_user_identity;
                sparseArray2.put(i5, sparseArray.get(i5));
                hVar2.f56178d.setTag(sparseArray2);
                arrayList.add(hVar2);
            }
            if (!"".equals(sparseArray.get(R.id.tag_forbid_user_name)) || !"".equals(sparseArray.get(R.id.tag_forbid_user_name_show))) {
                SparseArray sparseArray3 = new SparseArray();
                int i6 = R.id.tag_forbid_user_name;
                sparseArray3.put(i6, sparseArray.get(i6));
                int i7 = R.id.tag_forbid_user_name_show;
                sparseArray3.put(i7, sparseArray.get(i7));
                int i8 = R.id.tag_forbid_user_portrait;
                sparseArray3.put(i8, sparseArray.get(i8));
                int i9 = R.id.tag_manage_user_identity;
                sparseArray3.put(i9, sparseArray.get(i9));
                int i10 = R.id.tag_forbid_user_post_id;
                sparseArray3.put(i10, sparseArray.get(i10));
                d.a.r0.r.s.h hVar3 = new d.a.r0.r.s.h(11, this.f61036a.getString(R.string.forbidden_person), lVar);
                hVar3.f56178d.setTag(sparseArray3);
                arrayList.add(hVar3);
            }
            if ((sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                SparseArray sparseArray4 = new SparseArray();
                int i11 = R.id.tag_is_mem;
                sparseArray4.put(i11, sparseArray.get(i11));
                int i12 = R.id.tag_user_mute_mute_userid;
                sparseArray4.put(i12, sparseArray.get(i12));
                int i13 = R.id.tag_user_mute_mute_username;
                sparseArray4.put(i13, sparseArray.get(i13));
                int i14 = R.id.tag_user_mute_mute_nameshow;
                sparseArray4.put(i14, sparseArray.get(i14));
                int i15 = R.id.tag_user_mute_post_id;
                sparseArray4.put(i15, sparseArray.get(i15));
                int i16 = R.id.tag_user_mute_thread_id;
                sparseArray4.put(i16, sparseArray.get(i16));
                int i17 = R.id.tag_user_mute_msg;
                sparseArray4.put(i17, sparseArray.get(i17));
                if (z) {
                    hVar = new d.a.r0.r.s.h(12, this.f61036a.getString(R.string.un_mute), lVar);
                } else {
                    hVar = new d.a.r0.r.s.h(12, this.f61036a.getString(R.string.mute), lVar);
                }
                hVar.f56178d.setTag(sparseArray4);
                arrayList.add(hVar);
            }
            lVar.k(arrayList);
            d.a.r0.r.s.j jVar = this.q;
            if (jVar == null) {
                this.q = new d.a.r0.r.s.j(this.f61036a.getPageContext(), lVar);
            } else {
                jVar.h(lVar);
            }
            this.q.l();
        }
    }

    public void j0(View view) {
        SparseArray<Object> sparseArray;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048618, this, view) == null) || (sparseArray = (SparseArray) view.getTag()) == null) {
            return;
        }
        i0(sparseArray, false);
    }

    public void k0() {
        VideoPbFragment videoPbFragment;
        d.a.s0.h2.h.e D0;
        b2 N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (videoPbFragment = this.f61036a) == null || videoPbFragment.y() == null || this.f61036a.y().D0() == null || (N = (D0 = this.f61036a.y().D0()).N()) == null || N.H() == null) {
            return;
        }
        this.f61036a.s3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), N.H().getUserId());
        g0 g0Var = new g0();
        int U = this.f61036a.y().D0().U();
        boolean z = true;
        if (U != 1 && U != 3) {
            g0Var.f60536g = false;
        } else {
            g0Var.f60536g = true;
            g0Var.q = N.m0() == 1;
        }
        if (Z(U)) {
            g0Var.f60537h = true;
            g0Var.p = N.l0() == 1;
        } else {
            g0Var.f60537h = false;
        }
        if (U == 1002 && !equals) {
            g0Var.r = true;
        }
        g0Var.f60534e = q0(equals);
        g0Var.f60538i = t0();
        g0Var.f60535f = s0(equals);
        g0Var.k = equals && D0.T() != null && D0.T().showPbPrivate();
        g0Var.o = this.f61036a.y().R0();
        g0Var.f60531b = true;
        g0Var.f60530a = a0(equals);
        g0Var.n = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.m = this.f61036a.y().i0();
        g0Var.f60533d = true;
        if (N.l1() == null) {
            g0Var.f60532c = true;
        } else {
            g0Var.f60532c = false;
        }
        if (D0.e0()) {
            g0Var.f60531b = false;
            g0Var.f60533d = false;
            g0Var.f60532c = false;
            g0Var.f60536g = false;
            g0Var.f60537h = false;
        }
        g0Var.s = (TbSingleton.getInstance().mShowCallFans && equals && !D0.e0()) ? false : false;
        VideoPbFragment videoPbFragment2 = this.f61036a;
        if (videoPbFragment2.Z2(videoPbFragment2.y().D0()) != null) {
            VideoPbFragment videoPbFragment3 = this.f61036a;
            g0Var.t = videoPbFragment3.Z2(videoPbFragment3.y().D0()).S;
        }
        if (d.a.r0.c1.b.e.d()) {
            g0Var.f60533d = false;
            g0Var.f60531b = false;
            g0Var.f60532c = false;
        }
        B0(g0Var);
    }

    public final void l0(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, view) == null) || view == null) {
            return;
        }
        SparseArray sparseArray = (SparseArray) view.getTag();
        if (sparseArray == null) {
            sparseArray = new SparseArray();
        }
        sparseArray.put(R.id.pb_track_more_obj_source, Integer.valueOf(this.O ? 2 : 3));
        view.setTag(sparseArray);
    }

    public void m0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048621, this, z) == null) {
            this.O = z;
        }
    }

    public void n0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, str) == null) {
            this.H = str;
        }
    }

    public final boolean o0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            VideoPbFragment videoPbFragment = this.f61036a;
            return (videoPbFragment == null || videoPbFragment.y().D0().m().getDeletedReasonInfo() == null || 1 != this.f61036a.y().D0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void p0(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.a.s0.h2.k.e.f1.a.d(this.f61036a.getActivity(), this.f61036a.getPageContext(), new u(this, sparseArray, i2, z), new v(this));
        }
    }

    public final boolean q0(boolean z) {
        InterceptResult invokeZ;
        e0 e0Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
            VideoPbFragment videoPbFragment = this.f61036a;
            if (videoPbFragment == null || videoPbFragment.y() == null || this.f61036a.y().D0() == null) {
                return false;
            }
            d.a.s0.h2.h.e D0 = this.f61036a.y().D0();
            b2 N = D0.N();
            if (N != null) {
                if (N.E1() || N.H1()) {
                    return false;
                }
                if (N.F1() || N.G1()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if (N == null || N.H() == null || !N.H().isForumBusinessAccount() || v0.isOn()) {
                if (D0.m() == null || !D0.m().isBlockBawuDelete) {
                    if (D0.U() != 0) {
                        return D0.U() != 3;
                    }
                    List<x1> q2 = D0.q();
                    if (ListUtils.getCount(q2) > 0) {
                        for (x1 x1Var : q2) {
                            if (x1Var != null && (e0Var = x1Var.f56101g) != null && e0Var.f55926a && !e0Var.f55928c && ((i2 = e0Var.f55927b) == 1 || i2 == 2)) {
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public void r0(SparseArray<Object> sparseArray) {
        VideoPbFragment videoPbFragment;
        PostData postData;
        d.a.r0.r.s.h hVar;
        d.a.r0.r.s.h hVar2;
        d.a.r0.r.s.h hVar3;
        VideoPbFragment videoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, sparseArray) == null) || (videoPbFragment = this.f61036a) == null || videoPbFragment.y() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.f61038c == null) {
            d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(this.f61036a.getContext());
            this.f61038c = lVar;
            lVar.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.f61036a.y().D0() != null && this.f61036a.y().D0().e0();
        if (sparseArray != null) {
            boolean booleanValue = sparseArray.get(R.id.tag_del_post_is_self) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue() : false;
            boolean booleanValue2 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue3 = sparseArray.get(R.id.tag_should_manage_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_manage_visible)).booleanValue() : false;
            boolean booleanValue4 = sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue() : false;
            boolean booleanValue5 = sparseArray.get(R.id.tag_should_delete_visible) instanceof Boolean ? ((Boolean) sparseArray.get(R.id.tag_should_delete_visible)).booleanValue() : false;
            String str = sparseArray.get(R.id.tag_forbid_user_post_id) instanceof String ? (String) sparseArray.get(R.id.tag_forbid_user_post_id) : null;
            if (postData.q() != null) {
                boolean z2 = postData.q().hasAgree;
                int s2 = postData.s();
                if (z2 && s2 == 5) {
                    videoPbFragment2 = this.f61036a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    videoPbFragment2 = this.f61036a;
                    i2 = R.string.action_dislike;
                }
                d.a.r0.r.s.h hVar4 = new d.a.r0.r.s.h(8, videoPbFragment2.getString(i2), this.f61038c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                hVar4.f56178d.setTag(sparseArray2);
                arrayList.add(hVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    d.a.r0.r.s.h hVar5 = new d.a.r0.r.s.h(5, this.f61036a.getString(R.string.mute_option), this.f61038c);
                    SparseArray sparseArray3 = new SparseArray();
                    sparseArray3.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                    int i3 = R.id.tag_is_mem;
                    sparseArray3.put(i3, sparseArray.get(i3));
                    int i4 = R.id.tag_user_mute_mute_userid;
                    sparseArray3.put(i4, sparseArray.get(i4));
                    int i5 = R.id.tag_user_mute_mute_username;
                    sparseArray3.put(i5, sparseArray.get(i5));
                    int i6 = R.id.tag_user_mute_mute_nameshow;
                    sparseArray3.put(i6, sparseArray.get(i6));
                    int i7 = R.id.tag_user_mute_post_id;
                    sparseArray3.put(i7, sparseArray.get(i7));
                    int i8 = R.id.tag_user_mute_thread_id;
                    sparseArray3.put(i8, sparseArray.get(i8));
                    int i9 = R.id.tag_del_post_is_self;
                    sparseArray3.put(i9, sparseArray.get(i9));
                    int i10 = R.id.tag_del_post_type;
                    sparseArray3.put(i10, sparseArray.get(i10));
                    int i11 = R.id.tag_del_post_id;
                    sparseArray3.put(i11, sparseArray.get(i11));
                    int i12 = R.id.tag_manage_user_identity;
                    sparseArray3.put(i12, sparseArray.get(i12));
                    hVar5.f56178d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                } else {
                    if ((a0(booleanValue) && TbadkCoreApplication.isLogin()) && !z) {
                        d.a.r0.r.s.h hVar6 = new d.a.r0.r.s.h(5, this.f61036a.getString(R.string.report_text), this.f61038c);
                        hVar6.f56178d.setTag(str);
                        arrayList.add(hVar6);
                    }
                }
                if (booleanValue3) {
                    SparseArray sparseArray4 = new SparseArray();
                    sparseArray4.put(R.id.tag_should_manage_visible, Boolean.TRUE);
                    int i13 = R.id.tag_manage_user_identity;
                    sparseArray4.put(i13, sparseArray.get(i13));
                    int i14 = R.id.tag_forbid_user_name;
                    sparseArray4.put(i14, sparseArray.get(i14));
                    int i15 = R.id.tag_forbid_user_name_show;
                    sparseArray4.put(i15, sparseArray.get(i15));
                    int i16 = R.id.tag_forbid_user_portrait;
                    sparseArray4.put(i16, sparseArray.get(i16));
                    sparseArray4.put(R.id.tag_forbid_user_post_id, str);
                    if (booleanValue4) {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.TRUE);
                        int i17 = R.id.tag_is_mem;
                        sparseArray4.put(i17, sparseArray.get(i17));
                        int i18 = R.id.tag_user_mute_mute_userid;
                        sparseArray4.put(i18, sparseArray.get(i18));
                        int i19 = R.id.tag_user_mute_mute_username;
                        sparseArray4.put(i19, sparseArray.get(i19));
                        int i20 = R.id.tag_user_mute_mute_nameshow;
                        sparseArray4.put(i20, sparseArray.get(i20));
                        int i21 = R.id.tag_user_mute_post_id;
                        sparseArray4.put(i21, sparseArray.get(i21));
                        int i22 = R.id.tag_user_mute_thread_id;
                        sparseArray4.put(i22, sparseArray.get(i22));
                    } else {
                        sparseArray4.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    }
                    if (booleanValue5) {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                        sparseArray4.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                        int i23 = R.id.tag_del_post_id;
                        sparseArray4.put(i23, sparseArray.get(i23));
                        int i24 = R.id.tag_del_post_type;
                        sparseArray4.put(i24, sparseArray.get(i24));
                        int i25 = R.id.tag_has_sub_post;
                        sparseArray4.put(i25, sparseArray.get(i25));
                        hVar2 = new d.a.r0.r.s.h(6, this.f61036a.getString(R.string.delete), this.f61038c);
                        hVar2.f56178d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.a.r0.r.s.h(7, this.f61036a.getString(R.string.bar_manager), this.f61038c);
                    hVar.f56178d.setTag(sparseArray4);
                } else if (booleanValue5) {
                    SparseArray sparseArray5 = new SparseArray();
                    sparseArray5.put(R.id.tag_should_manage_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_user_mute_visible, Boolean.FALSE);
                    sparseArray5.put(R.id.tag_should_delete_visible, Boolean.TRUE);
                    int i26 = R.id.tag_manage_user_identity;
                    sparseArray5.put(i26, sparseArray.get(i26));
                    sparseArray5.put(R.id.tag_del_post_is_self, Boolean.valueOf(booleanValue));
                    int i27 = R.id.tag_del_post_id;
                    sparseArray5.put(i27, sparseArray.get(i27));
                    int i28 = R.id.tag_del_post_type;
                    sparseArray5.put(i28, sparseArray.get(i28));
                    int i29 = R.id.tag_has_sub_post;
                    sparseArray5.put(i29, sparseArray.get(i29));
                    if (this.f61036a.y().D0().U() == 1002 && !booleanValue) {
                        hVar3 = new d.a.r0.r.s.h(6, this.f61036a.getString(R.string.report_text), this.f61038c);
                    } else {
                        hVar3 = new d.a.r0.r.s.h(6, this.f61036a.getString(R.string.delete), this.f61038c);
                    }
                    hVar3.f56178d.setTag(sparseArray5);
                    hVar2 = hVar3;
                    hVar = null;
                } else {
                    hVar = null;
                    hVar2 = null;
                }
                if (hVar2 != null) {
                    arrayList.add(hVar2);
                }
                if (hVar != null) {
                    arrayList.add(hVar);
                }
                if (!booleanValue) {
                    arrayList.add(new d.a.r0.r.s.h(9, TbadkCoreApplication.getInst().getString(R.string.block_user), this.f61038c));
                }
            }
            this.f61038c.k(arrayList);
            d.a.r0.r.s.j jVar = new d.a.r0.r.s.j(this.f61036a.getPageContext(), this.f61038c);
            this.f61037b = jVar;
            jVar.l();
        }
    }

    public final boolean s0(boolean z) {
        InterceptResult invokeZ;
        VideoPbFragment videoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z)) == null) {
            if (z || (videoPbFragment = this.f61036a) == null || videoPbFragment.y() == null || this.f61036a.y().D0() == null || (this.f61036a.y().D0().m() != null && this.f61036a.y().D0().m().isBlockBawuDelete)) {
                return false;
            }
            d.a.s0.h2.h.e D0 = this.f61036a.y().D0();
            return ((D0.N() != null && D0.N().H() != null && D0.N().H().isForumBusinessAccount() && !v0.isOn()) || this.f61036a.y().D0().U() == 0 || this.f61036a.y().D0().U() == 3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            VideoPbFragment videoPbFragment = this.f61036a;
            if (videoPbFragment == null || videoPbFragment.y() == null || !this.f61036a.y().R0()) {
                return false;
            }
            return this.f61036a.y().B0() == null || this.f61036a.y().B0().c() != 0;
        }
        return invokeV.booleanValue;
    }

    public void u0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, metaData) == null) || metaData == null) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f61036a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new i(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new j(this, metaData));
        aVar.create(this.f61036a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.r == null) {
                this.r = new d.a.r0.r.f0.a(this.f61036a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final void w0(d.a.r0.r.s.a aVar, int i2, d.a.s0.h.h hVar, UserData userData) {
        VideoPbFragment videoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048631, this, aVar, i2, hVar, userData) == null) || (videoPbFragment = this.f61036a) == null || aVar == null) {
            return;
        }
        if (this.w == null && videoPbFragment.getView() != null) {
            this.w = new d.a.s0.h.i(this.f61036a.getPageContext(), this.f61036a.getView(), hVar, userData);
        }
        AntiData L = L();
        SparseArray<String> sparseArray = new SparseArray<>();
        if (L != null && L.getDelThreadInfoList() != null) {
            List<DeleteThreadInfo> delThreadInfoList = L.getDelThreadInfoList();
            for (int i3 = 0; i3 < delThreadInfoList.size(); i3++) {
                if (!TextUtils.isEmpty(delThreadInfoList.get(i3).text_info)) {
                    sparseArray.put(delThreadInfoList.get(i3).text_id, delThreadInfoList.get(i3).text_info);
                }
            }
        }
        w0 w0Var = new w0();
        w0Var.j(sparseArray);
        this.w.B(new String[]{this.f61036a.getString(R.string.delete_thread_reason_1), this.f61036a.getString(R.string.delete_thread_reason_2), this.f61036a.getString(R.string.delete_thread_reason_3), this.f61036a.getString(R.string.delete_thread_reason_4), this.f61036a.getString(R.string.delete_thread_reason_5)});
        this.w.A(w0Var);
        this.w.D((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.C(new e(this, aVar));
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            d.a.r0.r.s.a aVar = new d.a.r0.r.s.a(this.f61036a.getPageContext().getPageActivity());
            aVar.setMessage(this.f61036a.getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new x(this));
            aVar.setNegativeButton(R.string.cancel, new y(this));
            aVar.create(this.f61036a.getPageContext()).show();
        }
    }

    public void y0(boolean z, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048633, this, z, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.a.r0.r.s.j jVar = this.f61037b;
            if (jVar != null && jVar.isShowing()) {
                this.f61037b.dismiss();
                this.f61037b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(this.f61036a.getBaseFragmentActivity());
                lVar.n(new w(this, sparseArray, z, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.a.r0.r.s.h(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), lVar));
                }
                if (z) {
                    arrayList.add(new d.a.r0.r.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.a.r0.r.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.a.r0.r.s.j jVar2 = new d.a.r0.r.s.j(this.f61036a.getPageContext(), lVar);
                this.f61037b = jVar2;
                jVar2.l();
            }
        }
    }

    public void z0(b.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048634, this, cVar, z) == null) {
            d.a.r0.r.s.j jVar = this.f61039d;
            if (jVar != null) {
                jVar.dismiss();
                this.f61039d = null;
            }
            d.a.r0.r.s.l lVar = new d.a.r0.r.s.l(this.f61036a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.f61036a.y().D0() != null && this.f61036a.y().D0().N() != null && !this.f61036a.y().D0().N().I1()) {
                arrayList.add(new d.a.r0.r.s.h(0, this.f61036a.getPageContext().getString(R.string.save_to_emotion), lVar));
            }
            if (!z) {
                arrayList.add(new d.a.r0.r.s.h(1, this.f61036a.getPageContext().getString(R.string.save_to_local), lVar));
            }
            lVar.k(arrayList);
            lVar.n(new o(this, cVar));
            d.a.r0.r.s.j jVar2 = new d.a.r0.r.s.j(this.f61036a.getPageContext(), lVar);
            this.f61039d = jVar2;
            jVar2.l();
        }
    }
}
