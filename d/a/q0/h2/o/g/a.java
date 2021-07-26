package d.a.q0.h2.o.g;

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
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
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
import d.a.p0.b0.d;
import d.a.p0.s.q.b2;
import d.a.p0.s.q.e0;
import d.a.p0.s.q.m0;
import d.a.p0.s.q.w0;
import d.a.p0.s.q.x1;
import d.a.p0.s.s.a;
import d.a.p0.s.s.b;
import d.a.p0.s.s.l;
import d.a.q0.h.g;
import d.a.q0.h.j;
import d.a.q0.h2.k.e.f0;
import d.a.q0.h2.k.e.g0;
import d.a.q0.h2.k.e.x0;
import d.a.q0.u0.v0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.DeleteThreadInfo;
import tbclient.ForumToolPerm;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic = null;
    public static int Q = 0;
    public static int R = 3;
    public transient /* synthetic */ FieldHolder $fh;
    public d.a.d.k.d.a A;
    public String B;
    public TbRichTextMemeInfo C;
    public BdUniqueId D;
    public Object E;
    public PermissionJudgePolicy F;
    public PostData G;
    public String H;
    public Runnable I;
    public d.a.p0.s.b0.a J;
    public d.a.q0.h3.h0.e K;
    public boolean L;
    public final View.OnLongClickListener M;
    public l.e N;
    public boolean O;
    public final b.c P;

    /* renamed from: a  reason: collision with root package name */
    public AbsVideoPbFragment f58367a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.p0.s.s.j f58368b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.p0.s.s.l f58369c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.p0.s.s.j f58370d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.s.s.a f58371e;

    /* renamed from: f  reason: collision with root package name */
    public Dialog f58372f;

    /* renamed from: g  reason: collision with root package name */
    public Dialog f58373g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.s.s.e f58374h;

    /* renamed from: i  reason: collision with root package name */
    public View f58375i;
    public LinearLayout j;
    public TextView k;
    public TextView l;
    public List<CustomBlueCheckRadioButton> m;
    public String n;
    public ScrollView o;
    public CompoundButton.OnCheckedChangeListener p;
    public d.a.p0.s.s.j q;
    public d.a.p0.s.f0.a r;
    public d.a.p0.s.s.b s;
    public AlertDialog t;
    public f0 u;
    public d.a.q0.h.g v;
    public d.a.q0.h.j w;
    public d.a.q0.h2.k.f.a x;
    public PbFragment.t2 y;
    public x0 z;

    /* renamed from: d.a.q0.h2.o.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1446a implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58376a;

        public C1446a(a aVar) {
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
            this.f58376a = aVar;
        }

        @Override // d.a.p0.s.s.b.c
        public void a(d.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (bVar != null) {
                    bVar.e();
                }
                if (this.f58376a.A == null || TextUtils.isEmpty(this.f58376a.B)) {
                    return;
                }
                if (i2 == 0) {
                    if (this.f58376a.C == null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f58376a.B));
                    } else {
                        d.a aVar = new d.a();
                        aVar.f52031a = this.f58376a.B;
                        String str = "";
                        if (this.f58376a.C.memeInfo.pck_id.intValue() >= 0) {
                            str = "" + this.f58376a.C.memeInfo.pck_id;
                        }
                        aVar.f52032b = str;
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                    }
                } else if (i2 == 1) {
                    if (this.f58376a.F == null) {
                        this.f58376a.F = new PermissionJudgePolicy();
                    }
                    this.f58376a.F.clearRequestPermissionList();
                    this.f58376a.F.appendRequestPermission(this.f58376a.f58367a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                    if (this.f58376a.F.startRequestPermission(this.f58376a.f58367a.getPageContext().getPageActivity())) {
                        return;
                    }
                    if (this.f58376a.z == null) {
                        a aVar2 = this.f58376a;
                        aVar2.z = new x0(aVar2.f58367a.getPageContext());
                    }
                    this.f58376a.z.b(this.f58376a.B, this.f58376a.A.n());
                }
                this.f58376a.A = null;
                this.f58376a.B = null;
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58377e;

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
            this.f58377e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f58377e.f58367a.Q2(aVar, null);
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements g.InterfaceC1404g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f58378a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f58379b;

        public d(a aVar, d.a.p0.s.s.a aVar2) {
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
            this.f58379b = aVar;
            this.f58378a = aVar2;
        }

        @Override // d.a.q0.h.g.InterfaceC1404g
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f58379b.f58367a.Q2(this.f58378a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements j.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.a f58380a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f58381b;

        public e(a aVar, d.a.p0.s.s.a aVar2) {
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
            this.f58381b = aVar;
            this.f58380a = aVar2;
        }

        @Override // d.a.q0.h.j.h
        public void a(JSONArray jSONArray) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, jSONArray) == null) {
                this.f58381b.f58367a.Q2(this.f58380a, jSONArray);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f58382e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58383f;

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
            this.f58383f = aVar;
            this.f58382e = z;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f58383f.q.dismiss();
                SparseArray<Object> sparseArray = (SparseArray) view.getTag();
                if (sparseArray == null) {
                    return;
                }
                switch (i2) {
                    case 10:
                        this.f58383f.f0(((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray.get(R.id.tag_del_post_id), ((Integer) sparseArray.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray.get(R.id.tag_del_post_is_self)).booleanValue());
                        return;
                    case 11:
                        if (this.f58383f.y != null) {
                            this.f58383f.y.a(new Object[]{sparseArray.get(R.id.tag_manage_user_identity), sparseArray.get(R.id.tag_forbid_user_name), sparseArray.get(R.id.tag_forbid_user_post_id), sparseArray.get(R.id.tag_forbid_user_name_show), sparseArray.get(R.id.tag_forbid_user_portrait)});
                            return;
                        }
                        return;
                    case 12:
                        this.f58383f.T(this.f58382e, (String) sparseArray.get(R.id.tag_user_mute_mute_userid), sparseArray);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class g implements b.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58384a;

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
            this.f58384a = aVar;
        }

        @Override // d.a.p0.s.s.b.c
        public void a(d.a.p0.s.s.b bVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, bVar, i2, view) == null) {
                if (i2 == 0) {
                    TiebaStatic.eventStat(this.f58384a.f58367a.getPageContext().getPageActivity(), "pb_phone_call", NotificationCompat.CATEGORY_CALL);
                    a aVar = this.f58384a;
                    aVar.H = aVar.H.trim();
                    UtilHelper.callPhone(this.f58384a.f58367a.getPageContext().getPageActivity(), this.f58384a.H);
                    new d.a.q0.h2.k.e.d(this.f58384a.f58367a.y().b1(), this.f58384a.H, "1").start();
                    bVar.e();
                } else if (i2 == 1) {
                    TiebaStatic.eventStat(this.f58384a.f58367a.getPageContext().getPageActivity(), "pb_phone_sms", "sms");
                    a aVar2 = this.f58384a;
                    aVar2.H = aVar2.H.trim();
                    UtilHelper.smsPhone(this.f58384a.f58367a.getPageContext().getPageActivity(), this.f58384a.H);
                    new d.a.q0.h2.k.e.d(this.f58384a.f58367a.y().b1(), this.f58384a.H, "2").start();
                    bVar.e();
                } else if (i2 == 2) {
                    a aVar3 = this.f58384a;
                    aVar3.H = aVar3.H.trim();
                    UtilHelper.startBaiDuBar(this.f58384a.f58367a.getPageContext().getPageActivity(), this.f58384a.H);
                    bVar.e();
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class h implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.p0.s.s.j f58385e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ View f58386f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f58387g;

        public h(a aVar, d.a.p0.s.s.j jVar, View view) {
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
            this.f58387g = aVar;
            this.f58385e = jVar;
            this.f58386f = view;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
            if (r4.f58387g.f58367a.y().Y0() != 3) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d9  */
        /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        @Override // d.a.p0.s.s.l.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            boolean m2;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLIL(1048576, this, lVar, i2, view) != null) {
                return;
            }
            this.f58385e.dismiss();
            int i3 = 3;
            if (this.f58387g.f58367a.y().Y0() != 1 || i2 != 1) {
                if (this.f58387g.f58367a.y().Y0() == 2 && i2 == 0) {
                    i3 = 1;
                } else if (this.f58387g.f58367a.y().Y0() == 3 && i2 != 2) {
                    i3 = 2;
                } else if (i2 == 2) {
                }
                TiebaStatic.log("c12097");
                TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f58386f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
                if (this.f58387g.f58367a.y().L0().f57442f != null && this.f58387g.f58367a.y().L0().f57442f.size() > i2) {
                    i2 = this.f58387g.f58367a.y().L0().f57442f.get(i2).sort_type.intValue();
                }
                m2 = this.f58387g.f58367a.y().m2(i2);
                this.f58386f.setTag(Integer.valueOf(this.f58387g.f58367a.y().X0()));
                if (m2) {
                    return;
                }
                this.f58387g.f58367a.x4(true);
                return;
            }
            i3 = 0;
            TiebaStatic.log("c12097");
            TiebaStatic.log(new StatisticItem("c12097").param("obj_source", this.f58386f.getId() != R.id.pb_sort ? 1 : 0).param("obj_type", i3));
            if (this.f58387g.f58367a.y().L0().f57442f != null) {
                i2 = this.f58387g.f58367a.y().L0().f57442f.get(i2).sort_type.intValue();
            }
            m2 = this.f58387g.f58367a.y().m2(i2);
            this.f58386f.setTag(Integer.valueOf(this.f58387g.f58367a.y().X0()));
            if (m2) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class i implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f58388e;

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
            this.f58388e = metaData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f58388e.getUserId()).param("obj_locate", 2));
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class j implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MetaData f58389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58390f;

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
            this.f58390f = aVar;
            this.f58389e = metaData;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem("c12528").param("obj_id", this.f58389e.getUserId()).param("obj_locate", 1));
                aVar.dismiss();
                if (this.f58390f.f58367a.X2() != null) {
                    this.f58390f.f58367a.X2().m(!this.f58389e.hadConcerned(), this.f58389e.getPortrait(), this.f58389e.getUserId(), this.f58389e.isGod(), "6", this.f58390f.f58367a.getPageContext().getUniqueId(), this.f58390f.f58367a.y().getForumId(), "0");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class k implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58391e;

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
            this.f58391e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f58391e.t == null) {
                return;
            }
            d.a.d.e.m.g.a(this.f58391e.t, this.f58391e.f58367a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class m implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserMuteAddAndDelCustomMessage f58392e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58393f;

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
            this.f58393f = aVar;
            this.f58392e = userMuteAddAndDelCustomMessage;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f58393f.v0();
                MessageManager.getInstance().sendMessage(this.f58392e);
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class o implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b.c f58394e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f58395f;

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
            this.f58395f = aVar;
            this.f58394e = cVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                this.f58395f.f58370d.dismiss();
                this.f58394e.a(null, i2, view);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class p implements CompoundButton.OnCheckedChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58396e;

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
            this.f58396e = aVar;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, compoundButton, z) == null) && z) {
                this.f58396e.n = (String) compoundButton.getTag();
                if (this.f58396e.m != null) {
                    for (CustomBlueCheckRadioButton customBlueCheckRadioButton : this.f58396e.m) {
                        String str = (String) customBlueCheckRadioButton.getTag();
                        if (str != null && this.f58396e.n != null && !str.equals(this.f58396e.n)) {
                            customBlueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class q implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58397e;

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
            this.f58397e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && (this.f58397e.f58373g instanceof Dialog)) {
                d.a.d.e.m.g.b(this.f58397e.f58373g, this.f58397e.f58367a.getPageContext());
            }
        }
    }

    /* loaded from: classes8.dex */
    public class r implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58398e;

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
            this.f58398e = aVar;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view)) == null) ? this.f58398e.E(view) : invokeL.booleanValue;
        }
    }

    /* loaded from: classes8.dex */
    public class s implements PbFragment.t2 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f58399a;

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
            this.f58399a = aVar;
        }

        @Override // com.baidu.tieba.pb.pb.main.PbFragment.t2
        public void a(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!d.a.d.e.p.j.z()) {
                    this.f58399a.f58367a.showToast(R.string.network_not_available);
                    return;
                }
                Object[] objArr = (Object[]) obj;
                this.f58399a.f58367a.sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.f58399a.f58367a.getPageContext().getPageActivity(), this.f58399a.f58367a.y().L0().m().getId(), this.f58399a.f58367a.y().L0().m().getName(), this.f58399a.f58367a.y().L0().N().d0(), String.valueOf(this.f58399a.f58367a.y().L0().T().getUserId()), objArr.length > 1 ? String.valueOf(objArr[1]) : "", objArr.length > 3 ? String.valueOf(objArr[3]) : "", objArr.length > 2 ? String.valueOf(objArr[2]) : "", objArr.length > 4 ? String.valueOf(objArr[4]) : "")));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class t implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58400e;

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
            this.f58400e = aVar;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            SparseArray sparseArray;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f58400e.f58368b != null) {
                    this.f58400e.f58368b.dismiss();
                }
                this.f58400e.G0(i2);
                int i3 = 4;
                switch (i2) {
                    case -4:
                        View view2 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_share);
                        this.f58400e.l0(view2);
                        if (view2 != null) {
                            view2.performClick();
                            return;
                        }
                        return;
                    case -3:
                        View view3 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_reply);
                        this.f58400e.l0(view3);
                        if (view3 != null) {
                            view3.performClick();
                            return;
                        }
                        return;
                    case -2:
                        View view4 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        AgreeView agreeView = (AgreeView) view4;
                        this.f58400e.l0(view4);
                        if (agreeView == null || agreeView.getImgDisagree() == null) {
                            return;
                        }
                        agreeView.getImgDisagree().performClick();
                        return;
                    case -1:
                        View view5 = (View) ((SparseArray) view.getTag()).get(R.id.pb_dialog_item_zan_2);
                        this.f58400e.l0(view5);
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
                        if (this.f58400e.A == null || TextUtils.isEmpty(this.f58400e.B)) {
                            return;
                        }
                        if (this.f58400e.C == null) {
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, this.f58400e.B));
                        } else {
                            d.a aVar = new d.a();
                            aVar.f52031a = this.f58400e.B;
                            String str = "";
                            if (this.f58400e.C.memeInfo.pck_id.intValue() >= 0) {
                                str = "" + this.f58400e.C.memeInfo.pck_id;
                            }
                            aVar.f52032b = str;
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004610, aVar));
                        }
                        this.f58400e.A = null;
                        this.f58400e.B = null;
                        return;
                    case 2:
                        if (this.f58400e.A == null || TextUtils.isEmpty(this.f58400e.B)) {
                            return;
                        }
                        if (this.f58400e.F == null) {
                            this.f58400e.F = new PermissionJudgePolicy();
                        }
                        this.f58400e.F.clearRequestPermissionList();
                        this.f58400e.F.appendRequestPermission(this.f58400e.f58367a.getPageContext().getPageActivity(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (this.f58400e.F.startRequestPermission(this.f58400e.f58367a.getPageContext().getPageActivity())) {
                            return;
                        }
                        if (this.f58400e.z == null) {
                            a aVar2 = this.f58400e;
                            aVar2.z = new x0(aVar2.f58367a.getPageContext());
                        }
                        this.f58400e.z.b(this.f58400e.B, this.f58400e.A.n());
                        this.f58400e.A = null;
                        this.f58400e.B = null;
                        return;
                    case 3:
                        a aVar3 = this.f58400e;
                        PostData postData = aVar3.G;
                        if (postData != null) {
                            postData.h0(aVar3.f58367a.getPageContext().getPageActivity());
                            this.f58400e.G = null;
                            return;
                        }
                        return;
                    case 4:
                        TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 2));
                        if (this.f58400e.f58367a.checkUpIsLogin()) {
                            this.f58400e.c0(view);
                            if (this.f58400e.f58367a.y().L0().N() == null || this.f58400e.f58367a.y().L0().N().H() == null || this.f58400e.f58367a.y().L0().N().H().getUserId() == null || this.f58400e.f58367a.k3() == null) {
                                return;
                            }
                            a aVar4 = this.f58400e;
                            int S = aVar4.S(aVar4.f58367a.y().L0());
                            b2 N = this.f58400e.f58367a.y().L0().N();
                            if (N.F1()) {
                                i3 = 2;
                            } else if (N.I1()) {
                                i3 = 3;
                            } else if (!N.G1()) {
                                i3 = N.H1() ? 5 : 1;
                            }
                            TiebaStatic.log(new StatisticItem("c12526").param("tid", this.f58400e.f58367a.y().b1()).param("obj_locate", 2).param("obj_id", this.f58400e.f58367a.y().L0().N().H().getUserId()).param("obj_type", !this.f58400e.f58367a.k3().e()).param("obj_source", S).param("obj_param1", i3));
                            return;
                        }
                        return;
                    case 5:
                        if (!d.a.d.e.p.j.z()) {
                            this.f58400e.f58367a.showToast(R.string.network_not_available);
                            return;
                        }
                        Object tag = view.getTag();
                        if (tag instanceof String) {
                            TiebaStatic.log(new StatisticItem("c13079"));
                            this.f58400e.U((String) tag);
                            return;
                        } else if (tag instanceof SparseArray) {
                            TiebaStatic.log(new StatisticItem("c11739").param("obj_locate", 4));
                            SparseArray<Object> sparseArray2 = (SparseArray) tag;
                            if ((sparseArray2.get(R.id.tag_user_mute_visible) instanceof Boolean) && ((Boolean) sparseArray2.get(R.id.tag_user_mute_visible)).booleanValue()) {
                                sparseArray2.put(R.id.tag_from, 0);
                                sparseArray2.put(R.id.tag_check_mute_from, 2);
                                this.f58400e.B(sparseArray2);
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
                            AbsVideoPbFragment absVideoPbFragment = this.f58400e.f58367a;
                            if (absVideoPbFragment == null || absVideoPbFragment.z() == null) {
                                return;
                            }
                            boolean isHost = this.f58400e.f58367a.z().isHost(TbadkCoreApplication.getCurrentAccount());
                            if (isHost) {
                                if (!booleanValue2) {
                                    this.f58400e.p0(sparseArray3, intValue, booleanValue);
                                    return;
                                } else {
                                    this.f58400e.h0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue, null, isHost);
                                    return;
                                }
                            } else if (booleanValue && !booleanValue2) {
                                this.f58400e.p0(sparseArray3, intValue, booleanValue);
                                return;
                            } else {
                                this.f58400e.f0(((Integer) sparseArray3.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray3.get(R.id.tag_del_post_id), intValue, booleanValue);
                                return;
                            }
                        }
                        return;
                    case 7:
                        if (!d.a.d.e.p.j.z()) {
                            this.f58400e.f58367a.showToast(R.string.network_not_available);
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
                                this.f58400e.f0(((Integer) sparseArray4.get(R.id.tag_del_post_type)).intValue(), (String) sparseArray4.get(R.id.tag_del_post_id), ((Integer) sparseArray4.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) sparseArray4.get(R.id.tag_del_post_is_self)).booleanValue());
                                return;
                            }
                            return;
                        } else if (booleanValue5) {
                            sparseArray4.put(R.id.tag_from, 1);
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f58400e.B(sparseArray4);
                            return;
                        } else {
                            sparseArray4.put(R.id.tag_check_mute_from, 2);
                            this.f58400e.j0(view);
                            return;
                        }
                    case 8:
                        if (ViewHelper.checkUpIsLogin(this.f58400e.f58367a.getContext()) && (sparseArray = (SparseArray) view.getTag()) != null) {
                            PostData postData2 = (PostData) sparseArray.get(R.id.tag_clip_board);
                            if (postData2.q() == null) {
                                return;
                            }
                            d.a.p0.k0.c f2 = TbPageExtraHelper.f(view);
                            if (f2 != null) {
                                postData2.q().objSource = f2.a();
                            }
                            this.f58400e.C(postData2.q());
                            return;
                        }
                        return;
                    case 9:
                        AbsVideoPbFragment absVideoPbFragment2 = this.f58400e.f58367a;
                        if (absVideoPbFragment2 == null || absVideoPbFragment2.y() == null || this.f58400e.f58367a.y().L0() == null || !ViewHelper.checkUpIsLogin(this.f58400e.f58367a.getContext()) || this.f58400e.f58367a.z() == null) {
                            return;
                        }
                        this.f58400e.f58367a.z().showBlockDialog(d.a.q0.r3.a.b(view));
                        return;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class u implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f58401e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58402f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f58403g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f58404h;

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
            this.f58404h = aVar;
            this.f58401e = sparseArray;
            this.f58402f = i2;
            this.f58403g = z;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                if (aVar != null) {
                    aVar.dismiss();
                }
                this.f58404h.f58367a.R2(((Integer) this.f58401e.get(R.id.tag_del_post_type)).intValue(), (String) this.f58401e.get(R.id.tag_del_post_id), this.f58402f, this.f58403g);
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class w implements l.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SparseArray f58405e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f58406f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f58407g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f58408h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f58409i;

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
            this.f58409i = aVar;
            this.f58405e = sparseArray;
            this.f58406f = z;
            this.f58407g = str;
            this.f58408h = str2;
        }

        @Override // d.a.p0.s.s.l.e
        public void onItemClick(d.a.p0.s.s.l lVar, int i2, View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, lVar, i2, view) == null) {
                if (this.f58409i.f58368b != null) {
                    this.f58409i.f58368b.dismiss();
                }
                if (i2 == 0) {
                    this.f58409i.f0(((Integer) this.f58405e.get(R.id.tag_del_post_type)).intValue(), (String) this.f58405e.get(R.id.tag_del_post_id), ((Integer) this.f58405e.get(R.id.tag_manage_user_identity)).intValue(), ((Boolean) this.f58405e.get(R.id.tag_del_post_is_self)).booleanValue());
                } else if (i2 == 1) {
                    String str = (String) this.f58405e.get(R.id.tag_user_mute_mute_username);
                    String str2 = (String) this.f58405e.get(R.id.tag_user_mute_thread_id);
                    String str3 = (String) this.f58405e.get(R.id.tag_user_mute_post_id);
                    UserMuteAddAndDelCustomMessage userMuteAddAndDelCustomMessage = new UserMuteAddAndDelCustomMessage(2001430);
                    userMuteAddAndDelCustomMessage.setData(this.f58406f, this.f58407g, str, str2, str3, 1, this.f58408h, this.f58409i.D);
                    userMuteAddAndDelCustomMessage.setTag(this.f58409i.D);
                    this.f58409i.F0(this.f58406f, userMuteAddAndDelCustomMessage, this.f58408h, str, (String) this.f58405e.get(R.id.tag_user_mute_mute_nameshow));
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class x implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f58410e;

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
            this.f58410e = aVar;
        }

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log("c10025");
                aVar.dismiss();
                MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig((Context) this.f58410e.f58367a.getFragmentActivity(), 2, true, 4);
                if (!StringUtils.isNULL("4010001001")) {
                    memberPayActivityConfig.setSceneId("4010001001");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
            }
        }
    }

    /* loaded from: classes8.dex */
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

        @Override // d.a.p0.s.s.a.e
        public void onClick(d.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(332168508, "Ld/a/q0/h2/o/g/a;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(332168508, "Ld/a/q0/h2/o/g/a;");
        }
    }

    public a(AbsVideoPbFragment absVideoPbFragment) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {absVideoPbFragment};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f58370d = null;
        this.f58371e = null;
        this.f58372f = null;
        this.f58373g = null;
        this.f58374h = null;
        this.f58375i = null;
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
        this.L = d.a.p0.b.d.p0();
        this.M = new r(this);
        this.N = new t(this);
        this.P = new C1446a(this);
        this.f58367a = absVideoPbFragment;
        this.D = absVideoPbFragment.getUniqueId();
        d.a.q0.h2.k.f.a aVar = new d.a.q0.h2.k.f.a(this.f58367a.getContext());
        this.x = aVar;
        aVar.a(this.f58367a.getUniqueId());
        this.y = new s(this);
    }

    public void A0(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onItemClickListener) == null) {
            d.a.p0.s.s.e eVar = this.f58374h;
            if (eVar != null) {
                eVar.d();
                this.f58374h = null;
            }
            if (this.f58367a.y() == null) {
                return;
            }
            ArrayList<d.a.p0.s.s.n> arrayList = new ArrayList<>();
            arrayList.add(new d.a.p0.s.s.n(this.f58367a.getContext().getString(R.string.all_person), "", this.f58367a.y().U0() == 1, Integer.toString(1)));
            arrayList.add(new d.a.p0.s.s.n(this.f58367a.getContext().getString(R.string.my_fans), "", this.f58367a.y().U0() == 2, Integer.toString(5)));
            arrayList.add(new d.a.p0.s.s.n(this.f58367a.getContext().getString(R.string.my_attentions), "", this.f58367a.y().U0() == 3, Integer.toString(6)));
            arrayList.add(new d.a.p0.s.s.n(this.f58367a.getContext().getString(R.string.myself_only), "", this.f58367a.y().U0() == 4, Integer.toString(7)));
            d.a.p0.s.s.e eVar2 = new d.a.p0.s.s.e(this.f58367a.getPageContext());
            eVar2.l(R.string.pb_privacy_setting_thread_reply_decs);
            this.f58374h = eVar2;
            eVar2.k(arrayList, onItemClickListener);
            eVar2.c();
            this.f58374h.n();
        }
    }

    public void B(SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sparseArray) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            v0();
            UserMuteCheckCustomMessage userMuteCheckCustomMessage = new UserMuteCheckCustomMessage(2001429);
            userMuteCheckCustomMessage.userIdF = d.a.d.e.m.b.f(currentAccount, 0L);
            userMuteCheckCustomMessage.userIdT = d.a.d.e.m.b.f((String) sparseArray.get(R.id.tag_user_mute_mute_userid), 0L);
            BdUniqueId bdUniqueId = this.D;
            userMuteCheckCustomMessage.mId = bdUniqueId;
            userMuteCheckCustomMessage.setTag(bdUniqueId);
            this.E = sparseArray;
            MessageManager.getInstance().sendMessage(userMuteCheckCustomMessage);
        }
    }

    public void B0(g0 g0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, g0Var) == null) || this.f58367a.getBaseFragmentActivity().isProgressBarShown()) {
            return;
        }
        AbsVideoPbFragment absVideoPbFragment = this.f58367a;
        this.u = new f0(absVideoPbFragment, absVideoPbFragment.H1);
        AlertDialog create = new AlertDialog.Builder(this.f58367a.getContext(), R.style.DialogTheme).create();
        this.t = create;
        create.setCanceledOnTouchOutside(true);
        d.a.d.e.m.g.i(this.t, this.f58367a.getFragmentActivity());
        Window window = this.t.getWindow();
        window.addFlags(512);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.y = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.share_dialog_style);
        window.setGravity(80);
        window.setLayout(-1, -2);
        window.setContentView(this.u.s());
        this.u.K(g0Var == null ? false : g0Var.f57852a);
        this.u.x(g0Var == null ? false : g0Var.f57856e);
        this.u.F(g0Var == null ? false : g0Var.f57860i);
        this.u.y(g0Var == null ? false : g0Var.f57857f);
        this.u.M(g0Var != null ? g0Var.f57854c : true);
        this.u.J(g0Var == null ? false : g0Var.k);
        this.u.z(g0Var == null ? false : g0Var.l, g0Var.s);
        if (g0Var == null) {
            this.u.H(false, false);
            this.u.G(false, false);
        } else {
            this.u.H(g0Var.f57858g, g0Var.r);
            this.u.G(g0Var.f57859h, g0Var.q);
        }
        boolean z = g0Var == null ? false : g0Var.p;
        boolean z2 = g0Var == null ? false : g0Var.n;
        boolean z3 = g0Var == null ? false : g0Var.f57855d;
        boolean z4 = g0Var == null ? false : g0Var.f57853b;
        boolean z5 = g0Var == null ? false : g0Var.o;
        boolean z6 = g0Var == null ? false : g0Var.j;
        boolean z7 = g0Var == null ? false : g0Var.m;
        this.u.A(z3, z2);
        this.u.L(z4, z);
        this.u.I(z6, z5);
        this.u.P(z7);
        if (g0Var != null) {
            f0 f0Var = this.u;
            boolean z8 = g0Var.t;
            f0Var.v = z8;
            if (z8) {
                f0Var.f().setText(R.string.report_text);
                this.u.y(false);
            }
        }
        this.u.w(g0Var != null ? g0Var.u : false);
        if (!TbSingleton.getInstance().mCanCallFans && this.f58367a.y() != null && this.f58367a.y().L0() != null && this.f58367a.y().L0().P() != null && this.f58367a.y().L0().P().equals(TbSingleton.getInstance().mCallFansTid)) {
            this.u.d().setText(R.string.have_called_fans_short);
        }
        H0();
    }

    public final void C(AgreeData agreeData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, agreeData) == null) || agreeData == null) {
            return;
        }
        if (this.J == null) {
            this.J = new d.a.p0.s.b0.a();
        }
        if (this.K == null) {
            d.a.q0.h3.h0.e eVar = new d.a.q0.h3.h0.e();
            this.K = eVar;
            eVar.f58546a = this.f58367a.getUniqueId();
        }
        d.a.p0.s.q.f fVar = new d.a.p0.s.q.f();
        fVar.f53311b = 5;
        fVar.f53317h = 8;
        fVar.f53316g = 2;
        AbsVideoPbFragment absVideoPbFragment2 = this.f58367a;
        if (absVideoPbFragment2 != null && absVideoPbFragment2.y() != null) {
            fVar.f53315f = this.f58367a.y().K0();
        }
        fVar.f53310a = 2;
        int i2 = 1;
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 5) {
                agreeData.agreeType = 5;
                agreeData.hasAgree = false;
                fVar.f53318i = 0;
                this.J.c(agreeData, i2, this.f58367a.getUniqueId(), false);
                this.J.d(agreeData, this.K);
                absVideoPbFragment = this.f58367a;
                if (absVideoPbFragment != null || absVideoPbFragment.y() == null || this.f58367a.y().L0() == null) {
                    return;
                }
                this.J.b(this.f58367a.z(), fVar, agreeData, this.f58367a.y().L0().N());
                return;
            }
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            agreeData.agreeNum--;
            fVar.f53318i = 1;
        } else {
            agreeData.agreeType = 5;
            agreeData.hasAgree = true;
            fVar.f53318i = 1;
        }
        i2 = 0;
        this.J.c(agreeData, i2, this.f58367a.getUniqueId(), false);
        this.J.d(agreeData, this.K);
        absVideoPbFragment = this.f58367a;
        if (absVideoPbFragment != null) {
        }
    }

    public final void C0(d.a.p0.s.s.a aVar, int i2) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048580, this, aVar, i2) == null) || (absVideoPbFragment = this.f58367a) == null || aVar == null) {
            return;
        }
        if (this.v == null && absVideoPbFragment.getView() != null) {
            this.v = new d.a.q0.h.g(this.f58367a.getPageContext(), this.f58367a.getView());
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
        this.v.x(new String[]{this.f58367a.getString(R.string.delete_thread_reason_1), this.f58367a.getString(R.string.delete_thread_reason_2), this.f58367a.getString(R.string.delete_thread_reason_3), this.f58367a.getString(R.string.delete_thread_reason_4), this.f58367a.getString(R.string.delete_thread_reason_5)});
        this.v.w(w0Var);
        this.v.z((i2 == 1 || i2 == 2) ? "4" : "3");
        this.v.y(new d(this, aVar));
    }

    public final CustomBlueCheckRadioButton D(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048581, this, str, str2)) == null) {
            Activity pageActivity = this.f58367a.getPageContext().getPageActivity();
            CustomBlueCheckRadioButton customBlueCheckRadioButton = new CustomBlueCheckRadioButton(pageActivity);
            RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.a.d.e.p.l.g(pageActivity, R.dimen.ds100));
            customBlueCheckRadioButton.setOnCheckedChangeListener(this.p);
            customBlueCheckRadioButton.setTag(str);
            customBlueCheckRadioButton.setText(str2);
            customBlueCheckRadioButton.setLayoutParams(layoutParams);
            return customBlueCheckRadioButton;
        }
        return (CustomBlueCheckRadioButton) invokeLL.objValue;
    }

    public void D0(View view) {
        AbsVideoPbFragment absVideoPbFragment;
        String[] strArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, view) == null) || (absVideoPbFragment = this.f58367a) == null || absVideoPbFragment.y() == null) {
            return;
        }
        d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f58367a.getPageContext());
        if (this.f58367a.y().L0().f57442f == null || this.f58367a.y().L0().f57442f.size() <= 0) {
            strArr = new String[]{TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_new), TbadkCoreApplication.getInst().getResources().getString(R.string.sort_type_old)};
        } else {
            strArr = new String[this.f58367a.y().L0().f57442f.size()];
            for (int i2 = 0; i2 < this.f58367a.y().L0().f57442f.size(); i2++) {
                strArr[i2] = this.f58367a.y().L0().f57442f.get(i2).sort_name + TbadkCoreApplication.getInst().getResources().getString(R.string.sort_static);
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
        List<d.a.p0.s.s.h> b2;
        d.a.p0.s.s.h hVar;
        d.a.p0.s.s.h hVar2;
        d.a.p0.s.s.h hVar3;
        d.a.p0.s.s.h hVar4;
        d.a.d.k.d.a aVar;
        SparseArray sparseArray2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, view)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f58367a;
            if (absVideoPbFragment == null || !absVideoPbFragment.isAdded()) {
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
            if (postData == null || this.f58367a.k3() == null) {
                return true;
            }
            boolean z3 = this.f58367a.k3().e() && this.G.E() != null && this.G.E().equals(this.f58367a.y().G0());
            boolean z4 = this.f58367a.y().L0() != null && this.f58367a.y().L0().e0();
            if (this.f58369c == null) {
                d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58367a.getContext());
                this.f58369c = lVar;
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
                arrayList.add(new d.a.p0.s.s.h(1, TbadkCoreApplication.getInst().getString(R.string.save_to_emotion), this.f58369c));
            } else {
                z = booleanValue5;
                z2 = booleanValue6;
            }
            if (z6) {
                arrayList.add(new d.a.p0.s.s.h(2, TbadkCoreApplication.getInst().getString(R.string.save_to_local), this.f58369c));
            }
            if (!z5 && !z6) {
                d.a.p0.s.s.h hVar5 = new d.a.p0.s.s.h(3, TbadkCoreApplication.getInst().getString(R.string.copy), this.f58369c);
                SparseArray sparseArray3 = new SparseArray();
                sparseArray3.put(R.id.tag_clip_board, this.G);
                hVar5.f53561d.setTag(sparseArray3);
                arrayList.add(hVar5);
            }
            if (!booleanValue && !z4) {
                if (z3) {
                    hVar4 = new d.a.p0.s.s.h(4, TbadkCoreApplication.getInst().getString(R.string.remove_mark), this.f58369c);
                } else {
                    hVar4 = new d.a.p0.s.s.h(4, TbadkCoreApplication.getInst().getString(R.string.mark), this.f58369c);
                }
                SparseArray sparseArray4 = new SparseArray();
                sparseArray4.put(R.id.tag_clip_board, this.G);
                sparseArray4.put(R.id.tag_is_subpb, Boolean.FALSE);
                hVar4.f53561d.setTag(sparseArray4);
                arrayList.add(hVar4);
            }
            if (TbadkCoreApplication.isLogin() && !this.L) {
                if (!X() && !booleanValue4 && booleanValue3) {
                    d.a.p0.s.s.h hVar6 = new d.a.p0.s.s.h(5, TbadkCoreApplication.getInst().getString(R.string.mute_option), this.f58369c);
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
                    hVar6.f53561d.setTag(sparseArray5);
                    arrayList.add(hVar6);
                } else {
                    if ((a0(booleanValue2) && TbadkCoreApplication.isLogin()) && !z4) {
                        d.a.p0.s.s.h hVar7 = new d.a.p0.s.s.h(5, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f58369c);
                        hVar7.f53561d.setTag(str);
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
                        hVar2 = new d.a.p0.s.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f58369c);
                        hVar2.f53561d.setTag(sparseArray6);
                    } else {
                        sparseArray6.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.a.p0.s.s.h(7, TbadkCoreApplication.getInst().getString(R.string.bar_manager), this.f58369c);
                    hVar.f53561d.setTag(sparseArray6);
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
                    if (this.f58367a.y().L0().U() == 1002 && !booleanValue2) {
                        hVar3 = new d.a.p0.s.s.h(6, TbadkCoreApplication.getInst().getString(R.string.report_text), this.f58369c);
                    } else {
                        hVar3 = new d.a.p0.s.s.h(6, TbadkCoreApplication.getInst().getString(R.string.delete), this.f58369c);
                    }
                    hVar3.f53561d.setTag(sparseArray7);
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
                d.a.q0.h2.k.e.g1.a.a(arrayList, this.f58369c, this.G, this.f58367a.y());
            }
            if (d.a.p0.b.d.L()) {
                b2 = d.a.q0.h2.k.e.g1.a.c(arrayList, this.G.q(), sparseArray, this.f58369c);
            } else {
                b2 = d.a.q0.h2.k.e.g1.a.b(arrayList, this.G.q(), sparseArray, this.f58369c);
            }
            d.a.q0.h2.k.e.g1.a.k(b2, this.O);
            d.a.q0.h2.k.e.g1.a.e(b2);
            this.f58369c.o(d.a.q0.h2.k.e.g1.a.f(this.G));
            if (d.a.p0.b.d.L()) {
                this.f58369c.l(b2, false);
            } else {
                this.f58369c.l(b2, true);
            }
            d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f58367a.getPageContext(), this.f58369c);
            this.f58368b = jVar;
            jVar.l();
            TiebaStatic.log(new StatisticItem("c13272").param("tid", this.f58367a.y().b1()).param("fid", this.f58367a.y().getForumId()).param("uid", this.f58367a.y().L0().N().H().getUserId()).param("post_id", this.f58367a.y().y()).param("obj_source", booleanValue ? 2 : 1));
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
            AbsVideoPbFragment absVideoPbFragment = this.f58367a;
            if (absVideoPbFragment == null || absVideoPbFragment.getPageContext() == null) {
                return;
            }
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f58367a.getPageContext().getPageActivity());
            aVar.setMessage(str);
            aVar.setNegativeButton(R.string.know, new l(this));
            aVar.create(this.f58367a.getPageContext()).show();
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            I();
            this.f58367a.x3();
            d.a.p0.s.s.j jVar = this.f58368b;
            if (jVar != null) {
                jVar.dismiss();
            }
            this.f58367a.y3();
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
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f58367a.getBaseFragmentActivity());
            if (d.a.d.e.p.k.isEmpty(str)) {
                aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.block_mute_message_alert, str3));
            } else {
                aVar.setMessage(str);
            }
            aVar.setPositiveButton(R.string.confirm, new m(this, userMuteAddAndDelCustomMessage));
            aVar.setNegativeButton(R.string.cancel, new n(this));
            aVar.create(this.f58367a.getPageContext()).show();
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            I();
            this.f58367a.x3();
            d.a.p0.s.s.j jVar = this.f58368b;
            if (jVar != null) {
                jVar.dismiss();
            }
            K();
        }
    }

    public final void G0(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            TiebaStatic.log(new StatisticItem("c14000").param("tid", this.f58367a.y().b1()).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("obj_type", String.valueOf(d.a.q0.h2.k.e.g1.a.m(i2))));
        }
    }

    public void H() {
        d.a.p0.s.s.j jVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048589, this) == null) || (jVar = this.f58368b) == null) {
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
            d.a.d.e.m.e.a().postDelayed(this.I, 100L);
        }
    }

    public void J() {
        AlertDialog alertDialog;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048592, this) == null) || (alertDialog = this.t) == null) {
            return;
        }
        d.a.d.e.m.g.a(alertDialog, this.f58367a.getPageContext().getPageActivity());
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            d.a.p0.s.s.a aVar = this.f58371e;
            if (aVar != null) {
                aVar.dismiss();
            }
            Dialog dialog = this.f58372f;
            if (dialog != null) {
                d.a.d.e.m.g.b(dialog, this.f58367a.getPageContext());
            }
            Dialog dialog2 = this.f58373g;
            if (dialog2 != null) {
                d.a.d.e.m.g.b(dialog2, this.f58367a.getPageContext());
            }
            d.a.p0.s.s.j jVar = this.q;
            if (jVar != null) {
                jVar.dismiss();
            }
        }
    }

    public AntiData L() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            if (this.f58367a.y() == null || this.f58367a.y().L0() == null) {
                return null;
            }
            return this.f58367a.y().L0().d();
        }
        return (AntiData) invokeV.objValue;
    }

    public View M() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            View view = this.f58375i;
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

    public d.a.p0.s.s.b R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.s : (d.a.p0.s.s.b) invokeV.objValue;
    }

    public int S(d.a.q0.h2.h.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, eVar)) == null) {
            if (eVar == null || eVar.N() == null) {
                return 0;
            }
            if (eVar.N().k1() == 0) {
                return 1;
            }
            if (eVar.N().k1() == 54) {
                return 2;
            }
            return eVar.N().k1() == 40 ? 3 : 4;
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
            if (this.f58367a.y() != null && this.f58367a.y().L0() != null && this.f58367a.y().L0().e0()) {
                String format = String.format(TbConfig.URL_BJH_REPORT, this.f58367a.y().b1(), str);
                b2 N = this.f58367a.y().L0().N();
                if (N.F1()) {
                    format = format + "&channelid=33833";
                } else if (N.K1()) {
                    format = format + "&channelid=33842";
                } else if (N.I1()) {
                    format = format + "&channelid=33840";
                }
                b0(format);
                return;
            }
            this.x.i(str);
        }
    }

    public void V() {
        d.a.p0.s.f0.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || (aVar = this.r) == null) {
            return;
        }
        aVar.h(false);
    }

    public void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048605, this) == null) && this.s == null) {
            this.s = new d.a.p0.s.s.b(this.f58367a.getPageContext().getPageActivity());
            String[] strArr = {this.f58367a.getPageContext().getString(R.string.call_phone), this.f58367a.getPageContext().getString(R.string.sms_phone), this.f58367a.getPageContext().getString(R.string.search_in_baidu)};
            d.a.p0.s.s.b bVar = this.s;
            bVar.j(strArr, new g(this));
            bVar.g(b.C1227b.f53531a);
            bVar.h(17);
            bVar.c(this.f58367a.getPageContext());
        }
    }

    public boolean X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? d.a.q0.h2.k.e.g1.a.h(this.f58367a.y()) : invokeV.booleanValue;
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
                if ((i2 == 2 || i2 == 3 || i2 == 4) && this.f58367a.y().L0().T() != null && (forumToolAuth = this.f58367a.y().L0().T().getForumToolAuth()) != null) {
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
            if (this.f58367a.y() != null && this.f58367a.y().L0() != null) {
                return ((this.f58367a.y().L0().U() != 0) || this.f58367a.y().L0().N() == null || this.f58367a.y().L0().N().H() == null || TextUtils.equals(this.f58367a.y().L0().N().H().getUserId(), TbadkCoreApplication.getCurrentAccount()) || z) ? false : true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    public final void b0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, str) == null) {
            TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(this.f58367a.getContext(), "", str, true);
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
        if (postData.E() != null && postData.E().equals(this.f58367a.y().G0())) {
            z = true;
        }
        MarkData F0 = this.f58367a.y().F0(postData);
        if (this.f58367a.y().L0() != null && this.f58367a.y().L0().e0()) {
            AbsVideoPbFragment absVideoPbFragment = this.f58367a;
            PostData c3 = absVideoPbFragment.c3(absVideoPbFragment.y().L0());
            if (c3 != null) {
                F0 = this.f58367a.y().F0(c3);
            }
        }
        if (F0 == null) {
            return;
        }
        this.f58367a.D4();
        if (this.f58367a.k3() != null) {
            this.f58367a.k3().i(F0);
            if (!z) {
                this.f58367a.k3().a();
            } else {
                this.f58367a.k3().d();
            }
        }
    }

    public void e0(ArrayList<m0> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, arrayList) == null) {
            if (this.f58375i == null) {
                this.f58375i = LayoutInflater.from(this.f58367a.getPageContext().getPageActivity()).inflate(R.layout.commit_good, (ViewGroup) null);
            }
            this.f58367a.getBaseFragmentActivity().getLayoutMode().j(this.f58375i);
            if (this.f58373g == null) {
                Dialog dialog = new Dialog(this.f58367a.getPageContext().getPageActivity(), R.style.common_alert_dialog);
                this.f58373g = dialog;
                dialog.setCanceledOnTouchOutside(true);
                this.f58373g.setCancelable(true);
                this.o = (ScrollView) this.f58375i.findViewById(R.id.good_scroll);
                this.f58373g.setContentView(this.f58375i);
                WindowManager.LayoutParams attributes = this.f58373g.getWindow().getAttributes();
                attributes.width = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds540);
                this.f58373g.getWindow().setAttributes(attributes);
                this.p = new p(this);
                this.j = (LinearLayout) this.f58375i.findViewById(R.id.good_class_group);
                TextView textView = (TextView) this.f58375i.findViewById(R.id.dialog_button_cancel);
                this.l = textView;
                textView.setOnClickListener(new q(this));
                TextView textView2 = (TextView) this.f58375i.findViewById(R.id.dialog_button_ok);
                this.k = textView2;
                textView2.setOnClickListener(this.f58367a.h3());
            }
            this.j.removeAllViews();
            this.m = new ArrayList();
            CustomBlueCheckRadioButton D = D("0", this.f58367a.getPageContext().getString(R.string.thread_good_class));
            this.m.add(D);
            D.setChecked(true);
            this.j.addView(D);
            if (arrayList != null) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    m0 m0Var = arrayList.get(i2);
                    if (m0Var != null && !TextUtils.isEmpty(m0Var.b()) && m0Var.a() > 0) {
                        CustomBlueCheckRadioButton D2 = D(String.valueOf(m0Var.a()), m0Var.b());
                        this.m.add(D2);
                        View view = new View(this.f58367a.getPageContext().getPageActivity());
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.ds1));
                        SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                        view.setLayoutParams(layoutParams);
                        this.j.addView(view);
                        this.j.addView(D2);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = this.o.getLayoutParams();
                int size = arrayList.size();
                if (size == 0 || size == 1) {
                    layoutParams2.height = d.a.d.e.p.l.e(this.f58367a.getPageContext().getPageActivity(), 120.0f);
                } else if (size != 2) {
                    layoutParams2.height = d.a.d.e.p.l.e(this.f58367a.getPageContext().getPageActivity(), 220.0f);
                } else {
                    layoutParams2.height = d.a.d.e.p.l.e(this.f58367a.getPageContext().getPageActivity(), 186.0f);
                }
                this.o.setLayoutParams(layoutParams2);
                this.o.removeAllViews();
                LinearLayout linearLayout = this.j;
                if (linearLayout != null && linearLayout.getParent() == null) {
                    this.o.addView(this.j);
                }
            }
            d.a.d.e.m.g.j(this.f58373g, this.f58367a.getPageContext());
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
            this.f58371e = new d.a.p0.s.s.a(this.f58367a.getActivity());
            if (StringUtils.isNull(str2)) {
                this.f58371e.setMessageId(i4);
            } else {
                this.f58371e.setOnlyMessageShowCenter(false);
                this.f58371e.setMessage(str2);
            }
            this.f58371e.setYesButtonTag(sparseArray);
            this.f58371e.setPositiveButton(R.string.dialog_ok, new b(this));
            this.f58371e.setNegativeButton(R.string.dialog_cancel, new c(this));
            this.f58371e.setCancelable(true);
            this.f58371e.create(this.f58367a.getPageContext());
            if (z2) {
                this.f58371e.show();
            } else if (z) {
                this.f58371e.show();
            } else if (o0()) {
                d.a.q0.h.i iVar = new d.a.q0.h.i(this.f58367a.y().L0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue(), this.f58367a.y().L0().m().getDeletedReasonInfo().is_boomgrow.intValue(), this.f58367a.y().L0().p().has_forum_rule.intValue());
                iVar.i(this.f58367a.y().L0().m().getId(), this.f58367a.y().L0().m().getName());
                iVar.h(this.f58367a.y().L0().m().getImage_url());
                iVar.j(this.f58367a.y().L0().m().getUser_level());
                w0(this.f58371e, i2, iVar, this.f58367a.y().L0().T());
            } else {
                C0(this.f58371e, i2);
            }
        }
    }

    public void i0(SparseArray<Object> sparseArray, boolean z) {
        d.a.p0.s.s.h hVar;
        d.a.p0.s.s.h hVar2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, sparseArray, z) == null) {
            d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58367a.getContext());
            lVar.q(this.f58367a.getString(R.string.bar_manager));
            lVar.n(new f(this, z));
            ArrayList arrayList = new ArrayList();
            int intValue = sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1;
            if (!"".equals(sparseArray.get(R.id.tag_del_post_id)) && intValue != 2) {
                if ((sparseArray.get(R.id.tag_del_post_type) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_del_post_type)).intValue() : -1) == 0) {
                    hVar2 = new d.a.p0.s.s.h(10, this.f58367a.getString(R.string.delete_post), lVar);
                } else {
                    hVar2 = new d.a.p0.s.s.h(10, this.f58367a.getString(R.string.delete), lVar);
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
                hVar2.f53561d.setTag(sparseArray2);
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
                d.a.p0.s.s.h hVar3 = new d.a.p0.s.s.h(11, this.f58367a.getString(R.string.forbidden_person), lVar);
                hVar3.f53561d.setTag(sparseArray3);
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
                    hVar = new d.a.p0.s.s.h(12, this.f58367a.getString(R.string.un_mute), lVar);
                } else {
                    hVar = new d.a.p0.s.s.h(12, this.f58367a.getString(R.string.mute), lVar);
                }
                hVar.f53561d.setTag(sparseArray4);
                arrayList.add(hVar);
            }
            lVar.k(arrayList);
            d.a.p0.s.s.j jVar = this.q;
            if (jVar == null) {
                this.q = new d.a.p0.s.s.j(this.f58367a.getPageContext(), lVar);
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
        AbsVideoPbFragment absVideoPbFragment;
        d.a.q0.h2.h.e L0;
        b2 N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048619, this) == null) || (absVideoPbFragment = this.f58367a) == null || absVideoPbFragment.y() == null || this.f58367a.y().L0() == null || (N = (L0 = this.f58367a.y().L0()).N()) == null || N.H() == null) {
            return;
        }
        this.f58367a.x3();
        boolean equals = TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), N.H().getUserId());
        g0 g0Var = new g0();
        int U = this.f58367a.y().L0().U();
        boolean z = true;
        if (U != 1 && U != 3) {
            g0Var.f57858g = false;
        } else {
            g0Var.f57858g = true;
            g0Var.r = N.n0() == 1;
        }
        if (Z(U)) {
            g0Var.f57859h = true;
            g0Var.q = N.m0() == 1;
        } else {
            g0Var.f57859h = false;
        }
        if (U == 1002 && !equals) {
            g0Var.t = true;
        }
        g0Var.f57856e = q0(equals);
        g0Var.f57860i = t0();
        g0Var.f57857f = s0(equals);
        g0Var.k = equals && L0.T() != null && L0.T().showPbPrivate();
        if (TbSingleton.getInstance().getTiebaPlusConfigData() != null) {
            g0Var.l = TbSingleton.getInstance().getTiebaPlusConfigData().c();
        }
        g0Var.s = equals;
        g0Var.p = this.f58367a.y().Z0();
        g0Var.f57853b = true;
        g0Var.f57852a = a0(equals);
        g0Var.o = TbadkCoreApplication.getInst().getSkinType() == 1;
        g0Var.j = true;
        g0Var.n = this.f58367a.y().q0();
        g0Var.f57855d = true;
        if (N.m1() == null) {
            g0Var.f57854c = true;
        } else {
            g0Var.f57854c = false;
        }
        if (L0.e0()) {
            g0Var.f57853b = false;
            g0Var.f57855d = false;
            g0Var.f57854c = false;
            g0Var.f57858g = false;
            g0Var.f57859h = false;
        }
        g0Var.u = (TbSingleton.getInstance().mShowCallFans && equals && !L0.e0()) ? false : false;
        AbsVideoPbFragment absVideoPbFragment2 = this.f58367a;
        if (absVideoPbFragment2.c3(absVideoPbFragment2.y().L0()) != null) {
            AbsVideoPbFragment absVideoPbFragment3 = this.f58367a;
            g0Var.v = absVideoPbFragment3.c3(absVideoPbFragment3.y().L0()).S;
        }
        if (d.a.p0.e1.b.e.d()) {
            g0Var.f57855d = false;
            g0Var.f57853b = false;
            g0Var.f57854c = false;
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
            AbsVideoPbFragment absVideoPbFragment = this.f58367a;
            return (absVideoPbFragment == null || absVideoPbFragment.y().L0().m().getDeletedReasonInfo() == null || 1 != this.f58367a.y().L0().m().getDeletedReasonInfo().is_grays_cale_forum.intValue()) ? false : true;
        }
        return invokeV.booleanValue;
    }

    public final void p0(SparseArray<Object> sparseArray, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048624, this, new Object[]{sparseArray, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.a.q0.h2.k.e.g1.a.d(this.f58367a.getActivity(), this.f58367a.getPageContext(), new u(this, sparseArray, i2, z), new v(this));
        }
    }

    public final boolean q0(boolean z) {
        InterceptResult invokeZ;
        e0 e0Var;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048625, this, z)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f58367a;
            if (absVideoPbFragment == null || absVideoPbFragment.y() == null || this.f58367a.y().L0() == null) {
                return false;
            }
            d.a.q0.h2.h.e L0 = this.f58367a.y().L0();
            b2 N = L0.N();
            if (N != null) {
                if (N.F1() || N.I1()) {
                    return false;
                }
                if (N.G1() || N.H1()) {
                    return z;
                }
            }
            if (z) {
                return true;
            }
            if ((N == null || N.H() == null || !N.H().isForumBusinessAccount() || v0.isOn()) && !this.f58367a.y().D()) {
                if (L0.m() == null || !L0.m().isBlockBawuDelete) {
                    if (L0.U() != 0) {
                        return L0.U() != 3;
                    }
                    List<x1> q2 = L0.q();
                    if (ListUtils.getCount(q2) > 0) {
                        for (x1 x1Var : q2) {
                            if (x1Var != null && (e0Var = x1Var.f53484g) != null && e0Var.f53305a && !e0Var.f53307c && ((i2 = e0Var.f53306b) == 1 || i2 == 2)) {
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
        AbsVideoPbFragment absVideoPbFragment;
        PostData postData;
        d.a.p0.s.s.h hVar;
        d.a.p0.s.s.h hVar2;
        d.a.p0.s.s.h hVar3;
        AbsVideoPbFragment absVideoPbFragment2;
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048626, this, sparseArray) == null) || (absVideoPbFragment = this.f58367a) == null || absVideoPbFragment.y() == null || sparseArray == null || (postData = (PostData) sparseArray.get(R.id.tag_clip_board)) == null) {
            return;
        }
        if (this.f58369c == null) {
            d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58367a.getContext());
            this.f58369c = lVar;
            lVar.n(this.N);
        }
        ArrayList arrayList = new ArrayList();
        boolean z = this.f58367a.y().L0() != null && this.f58367a.y().L0().e0();
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
                    absVideoPbFragment2 = this.f58367a;
                    i2 = R.string.action_cancel_dislike;
                } else {
                    absVideoPbFragment2 = this.f58367a;
                    i2 = R.string.action_dislike;
                }
                d.a.p0.s.s.h hVar4 = new d.a.p0.s.s.h(8, absVideoPbFragment2.getString(i2), this.f58369c);
                SparseArray sparseArray2 = new SparseArray();
                sparseArray2.put(R.id.tag_clip_board, postData);
                hVar4.f53561d.setTag(sparseArray2);
                arrayList.add(hVar4);
            }
            if (TbadkCoreApplication.isLogin()) {
                if (!booleanValue3 && booleanValue2) {
                    d.a.p0.s.s.h hVar5 = new d.a.p0.s.s.h(5, this.f58367a.getString(R.string.mute_option), this.f58369c);
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
                    hVar5.f53561d.setTag(sparseArray3);
                    arrayList.add(hVar5);
                } else {
                    if ((a0(booleanValue) && TbadkCoreApplication.isLogin()) && !z) {
                        d.a.p0.s.s.h hVar6 = new d.a.p0.s.s.h(5, this.f58367a.getString(R.string.report_text), this.f58369c);
                        hVar6.f53561d.setTag(str);
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
                        hVar2 = new d.a.p0.s.s.h(6, this.f58367a.getString(R.string.delete), this.f58369c);
                        hVar2.f53561d.setTag(sparseArray4);
                    } else {
                        sparseArray4.put(R.id.tag_should_delete_visible, Boolean.FALSE);
                        hVar2 = null;
                    }
                    hVar = new d.a.p0.s.s.h(7, this.f58367a.getString(R.string.bar_manager), this.f58369c);
                    hVar.f53561d.setTag(sparseArray4);
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
                    if (this.f58367a.y().L0().U() == 1002 && !booleanValue) {
                        hVar3 = new d.a.p0.s.s.h(6, this.f58367a.getString(R.string.report_text), this.f58369c);
                    } else {
                        hVar3 = new d.a.p0.s.s.h(6, this.f58367a.getString(R.string.delete), this.f58369c);
                    }
                    hVar3.f53561d.setTag(sparseArray5);
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
                    arrayList.add(new d.a.p0.s.s.h(9, TbadkCoreApplication.getInst().getString(R.string.block_user), this.f58369c));
                }
            }
            this.f58369c.k(arrayList);
            d.a.p0.s.s.j jVar = new d.a.p0.s.s.j(this.f58367a.getPageContext(), this.f58369c);
            this.f58368b = jVar;
            jVar.l();
        }
    }

    public final boolean s0(boolean z) {
        InterceptResult invokeZ;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048627, this, z)) == null) {
            if (z || (absVideoPbFragment = this.f58367a) == null || absVideoPbFragment.y() == null || this.f58367a.y().L0() == null || (this.f58367a.y().L0().m() != null && this.f58367a.y().L0().m().isBlockBawuDelete)) {
                return false;
            }
            d.a.q0.h2.h.e L0 = this.f58367a.y().L0();
            return ((L0.N() != null && L0.N().H() != null && L0.N().H().isForumBusinessAccount() && !v0.isOn()) || this.f58367a.y().D() || this.f58367a.y().L0().U() == 0 || this.f58367a.y().L0().U() == 3) ? false : true;
        }
        return invokeZ.booleanValue;
    }

    public final boolean t0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048628, this)) == null) {
            AbsVideoPbFragment absVideoPbFragment = this.f58367a;
            if (absVideoPbFragment == null || absVideoPbFragment.y() == null || !this.f58367a.y().Z0()) {
                return false;
            }
            return this.f58367a.y().J0() == null || this.f58367a.y().J0().c() != 0;
        }
        return invokeV.booleanValue;
    }

    public void u0(MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048629, this, metaData) == null) || metaData == null) {
            return;
        }
        d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f58367a.getActivity());
        aVar.setTitle(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_done));
        aVar.setTitleShowCenter(true);
        aVar.setMessage(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like));
        aVar.setMessageShowCenter(true);
        aVar.setCancelable(false);
        aVar.setNegativeButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_cancel), new i(this, metaData));
        aVar.setPositiveButton(TbadkCoreApplication.getInst().getResources().getString(R.string.mark_like_confirm), new j(this, metaData));
        aVar.create(this.f58367a.getPageContext()).show();
        TiebaStatic.log(new StatisticItem("c12527"));
    }

    public void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048630, this) == null) {
            if (this.r == null) {
                this.r = new d.a.p0.s.f0.a(this.f58367a.getPageContext());
            }
            this.r.h(true);
        }
    }

    public final void w0(d.a.p0.s.s.a aVar, int i2, d.a.q0.h.i iVar, UserData userData) {
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048631, this, aVar, i2, iVar, userData) == null) || (absVideoPbFragment = this.f58367a) == null || aVar == null) {
            return;
        }
        if (this.w == null && absVideoPbFragment.getView() != null) {
            this.w = new d.a.q0.h.j(this.f58367a.getPageContext(), this.f58367a.getView(), iVar, userData);
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
        this.w.B(new String[]{this.f58367a.getString(R.string.delete_thread_reason_1), this.f58367a.getString(R.string.delete_thread_reason_2), this.f58367a.getString(R.string.delete_thread_reason_3), this.f58367a.getString(R.string.delete_thread_reason_4), this.f58367a.getString(R.string.delete_thread_reason_5)});
        this.w.A(w0Var);
        this.w.D((i2 == 1 || i2 == 2) ? "4" : "3");
        this.w.C(new e(this, aVar));
    }

    public void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048632, this) == null) {
            d.a.p0.s.s.a aVar = new d.a.p0.s.s.a(this.f58367a.getPageContext().getPageActivity());
            aVar.setMessage(this.f58367a.getResources().getString(R.string.mute_is_super_member_function));
            aVar.setPositiveButton(R.string.open_now, new x(this));
            aVar.setNegativeButton(R.string.cancel, new y(this));
            aVar.create(this.f58367a.getPageContext()).show();
        }
    }

    public void y0(boolean z, SparseArray<Object> sparseArray) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZL(1048633, this, z, sparseArray) == null) && (sparseArray.get(R.id.tag_user_mute_mute_userid) instanceof String) && (sparseArray.get(R.id.tag_user_mute_visible) instanceof Boolean) && (sparseArray.get(R.id.tag_check_mute_from) instanceof Integer)) {
            d.a.p0.s.s.j jVar = this.f58368b;
            if (jVar != null && jVar.isShowing()) {
                this.f58368b.dismiss();
                this.f58368b = null;
            }
            String str = (String) sparseArray.get(R.id.tag_user_mute_msg);
            String str2 = (String) sparseArray.get(R.id.tag_user_mute_mute_userid);
            if (((Boolean) sparseArray.get(R.id.tag_user_mute_visible)).booleanValue()) {
                d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58367a.getBaseFragmentActivity());
                lVar.n(new w(this, sparseArray, z, str2, str));
                ArrayList arrayList = new ArrayList();
                if ((sparseArray.get(R.id.tag_check_mute_from) instanceof Integer ? ((Integer) sparseArray.get(R.id.tag_check_mute_from)).intValue() : -1) == 1) {
                    arrayList.add(new d.a.p0.s.s.h(0, TbadkCoreApplication.getInst().getResources().getString(R.string.delete), lVar));
                }
                if (z) {
                    arrayList.add(new d.a.p0.s.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.un_mute), lVar));
                } else {
                    arrayList.add(new d.a.p0.s.s.h(1, TbadkCoreApplication.getInst().getResources().getString(R.string.mute), lVar));
                }
                lVar.k(arrayList);
                d.a.p0.s.s.j jVar2 = new d.a.p0.s.s.j(this.f58367a.getPageContext(), lVar);
                this.f58368b = jVar2;
                jVar2.l();
            }
        }
    }

    public void z0(b.c cVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048634, this, cVar, z) == null) {
            d.a.p0.s.s.j jVar = this.f58370d;
            if (jVar != null) {
                jVar.dismiss();
                this.f58370d = null;
            }
            d.a.p0.s.s.l lVar = new d.a.p0.s.s.l(this.f58367a.getContext());
            ArrayList arrayList = new ArrayList();
            if (this.f58367a.y().L0() != null && this.f58367a.y().L0().N() != null && !this.f58367a.y().L0().N().J1()) {
                arrayList.add(new d.a.p0.s.s.h(0, this.f58367a.getPageContext().getString(R.string.save_to_emotion), lVar));
            }
            if (!z) {
                arrayList.add(new d.a.p0.s.s.h(1, this.f58367a.getPageContext().getString(R.string.save_to_local), lVar));
            }
            lVar.k(arrayList);
            lVar.n(new o(this, cVar));
            d.a.p0.s.s.j jVar2 = new d.a.p0.s.s.j(this.f58367a.getPageContext(), lVar);
            this.f58370d = jVar2;
            jVar2.l();
        }
    }
}
