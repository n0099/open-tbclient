package d.a.s0.h2.g.d;

import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.h2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f60072a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f60073b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f60074c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f60075d;

    /* renamed from: e  reason: collision with root package name */
    public View f60076e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f60077f;

    /* renamed from: g  reason: collision with root package name */
    public View f60078g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f60079h;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f60080e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f60081f;

        public a(b bVar, Post post) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, post};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f60081f = bVar;
            this.f60080e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.f60080e) == null || post.id == null || this.f60081f.f60079h == null) {
                return;
            }
            this.f60081f.f60079h.a(String.valueOf(this.f60080e.id));
        }
    }

    public b(ViewStub viewStub, c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewStub, aVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f60075d = viewStub;
        this.f60079h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f60076e == null) {
            View inflate = this.f60075d.inflate();
            this.f60076e = inflate;
            this.f60072a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f60073b = (TextView) this.f60076e.findViewById(R.id.chosen_pb_comment_name);
            this.f60074c = (TbRichTextView) this.f60076e.findViewById(R.id.chosen_pb_comment_content);
            this.f60077f = (ImageView) this.f60076e.findViewById(R.id.chosen_pb_comment_reply);
            this.f60078g = this.f60076e.findViewById(R.id.chosen_pb_comment_line);
            this.f60074c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f60073b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f60077f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f60078g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f60074c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f60076e) == null) {
            return;
        }
        view.setVisibility(z ? 0 : 8);
    }

    public boolean e(Context context, Post post, User user) {
        InterceptResult invokeLLL;
        List<PbContent> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048579, this, context, post, user)) == null) {
            if (post != null && user != null && (list = post.content) != null && !list.isEmpty()) {
                b();
                d(true);
                this.f60073b.setText(user.name_show);
                this.f60077f.setOnClickListener(new a(this, post));
                this.f60072a.M(user.portrait, 12, false);
                this.f60074c.setVisibility(0);
                this.f60074c.setText(TbRichTextView.U(context, post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
