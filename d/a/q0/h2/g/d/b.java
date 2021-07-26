package d.a.q0.h2.g.d;

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
import d.a.q0.h2.g.d.c;
import java.util.List;
import tbclient.PbContent;
import tbclient.Post;
import tbclient.User;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public HeadImageView f57372a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f57373b;

    /* renamed from: c  reason: collision with root package name */
    public TbRichTextView f57374c;

    /* renamed from: d  reason: collision with root package name */
    public ViewStub f57375d;

    /* renamed from: e  reason: collision with root package name */
    public View f57376e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f57377f;

    /* renamed from: g  reason: collision with root package name */
    public View f57378g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f57379h;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Post f57380e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ b f57381f;

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
            this.f57381f = bVar;
            this.f57380e = post;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Post post;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (post = this.f57380e) == null || post.id == null || this.f57381f.f57379h == null) {
                return;
            }
            this.f57381f.f57379h.a(String.valueOf(this.f57380e.id));
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
        this.f57375d = viewStub;
        this.f57379h = aVar;
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.f57376e == null) {
            View inflate = this.f57375d.inflate();
            this.f57376e = inflate;
            this.f57372a = (HeadImageView) inflate.findViewById(R.id.chosen_pb_comment_head);
            this.f57373b = (TextView) this.f57376e.findViewById(R.id.chosen_pb_comment_name);
            this.f57374c = (TbRichTextView) this.f57376e.findViewById(R.id.chosen_pb_comment_content);
            this.f57377f = (ImageView) this.f57376e.findViewById(R.id.chosen_pb_comment_reply);
            this.f57378g = this.f57376e.findViewById(R.id.chosen_pb_comment_line);
            this.f57374c.setTextSize(TbConfig.getContentSize());
            c();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SkinManager.setViewTextColor(this.f57373b, R.color.CAM_X0106, 1);
            SkinManager.setImageResource(this.f57377f, R.drawable.btn_comment_list);
            SkinManager.setBackgroundColor(this.f57378g, R.color.CAM_X0204);
            TbRichTextView tbRichTextView = this.f57374c;
            if (tbRichTextView != null) {
                tbRichTextView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            }
        }
    }

    public void d(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) || (view = this.f57376e) == null) {
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
                this.f57373b.setText(user.name_show);
                this.f57377f.setOnClickListener(new a(this, post));
                this.f57372a.M(user.portrait, 12, false);
                this.f57374c.setVisibility(0);
                this.f57374c.setText(TbRichTextView.V(context, post.content, false));
                return true;
            }
            d(false);
            return false;
        }
        return invokeLLL.booleanValue;
    }
}
