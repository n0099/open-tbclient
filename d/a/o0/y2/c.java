package d.a.o0.y2;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.imageManager.TbFaceManager;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.sharewrite.ShareSDKImageView;
import com.baidu.tieba.sharewrite.WriteShareActivity;
import d.a.c.e.p.l;
import d.a.o0.w3.h;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes5.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public WriteData f67265c;

    /* renamed from: f  reason: collision with root package name */
    public View f67268f;
    public PostPrefixData k;
    public TextView l;
    public d.a.o0.w3.h m;
    public ImageView n;
    public View o;
    public LinearLayout p;
    public LinearLayout q;
    public ShareSDKImageView r;
    public TextView s;
    public TextView t;
    public WriteShareActivity u;
    public d.a.n0.b0.b v;

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f67263a = null;

    /* renamed from: b  reason: collision with root package name */
    public View f67264b = null;

    /* renamed from: d  reason: collision with root package name */
    public EditText f67266d = null;

    /* renamed from: e  reason: collision with root package name */
    public View f67267e = null;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f67269g = null;

    /* renamed from: h  reason: collision with root package name */
    public EditText f67270h = null;

    /* renamed from: i  reason: collision with root package name */
    public TextView f67271i = null;
    public RelativeLayout j = null;
    public boolean w = false;
    public int x = 0;
    public int y = 0;

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (c.this.r.getLoadedWidth() == 0 || c.this.r.getLoadedHeight() == 0) {
                    return;
                }
                c cVar = c.this;
                cVar.x = cVar.r.getLoadedWidth();
                c cVar2 = c.this;
                cVar2.y = cVar2.r.getLoadedHeight();
                if (c.this.u != null) {
                    c.this.u.getWriteData().setShareSummaryImgWidth(c.this.x);
                    c.this.u.getWriteData().setShareSummaryImgHeight(c.this.y);
                    c.this.w = true;
                    c.this.A();
                    return;
                }
                return;
            }
            c.this.w = false;
            c.this.A();
            if (c.this.u != null) {
                c.this.u.shareFailed(R.string.share_load_image_fail_tip);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            c.this.w = false;
            c.this.A();
            if (c.this.u != null) {
                c.this.u.shareFailed(R.string.share_load_image_fail_tip);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a.n0.a0.b {
        public b() {
        }

        @Override // d.a.n0.a0.b
        public void a(d.a.c.k.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) c.this.p.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* renamed from: d.a.o0.y2.c$c  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1812c implements View.OnClickListener {
        public View$OnClickListenerC1812c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.l.setVisibility(0);
            c.this.o.setSelected(true);
            d.a.c.e.m.g.l(c.this.m, view, l.e(c.this.u.getPageContext().getContext(), 15.0f), l.e(c.this.u.getPageContext().getContext(), 1.0f));
            if (c.this.u != null) {
                c.this.u.hidenSoftKeyPad();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.l.setSelected(true);
            d.a.c.e.m.g.l(c.this.m, view, l.e(c.this.u.getPageContext().getContext(), 15.0f), l.e(c.this.u.getPageContext().getContext(), 1.0f));
            if (c.this.u != null) {
                c.this.u.hidenSoftKeyPad();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements h.a {
        public e() {
        }

        @Override // d.a.o0.w3.h.a
        public void onPrefixItemClick(int i2) {
            c.this.u.setCurrentPrefixPosition(i2);
            c.this.l.setText(c.this.k.getPrefixs().get(i2));
            c.this.m.c(i2);
            c.this.A();
            d.a.c.e.m.g.d(c.this.m, c.this.u.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class f implements PopupWindow.OnDismissListener {
        public f() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            c.this.o.setSelected(false);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.this.A();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnTouchListener {
        public h(c cVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                view.requestFocus();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes5.dex */
    public class i implements TextWatcher {
        public i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.this.A();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public c(WriteShareActivity writeShareActivity) {
        this.f67265c = null;
        this.u = writeShareActivity;
        this.f67265c = writeShareActivity.getWriteData();
        if (this.v == null) {
            this.v = new d.a.n0.b0.b();
        }
        w();
    }

    public void A() {
        String str = "1";
        if (this.f67265c.getType() == 3) {
            String trim = this.f67266d.getText().toString().trim();
            PostPrefixData postPrefixData = this.k;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                if (this.u.getCurrentPrefixPosition() == this.k.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.f67265c.setIsNoTitle(true);
                    } else {
                        this.f67265c.setIsNoTitle(false);
                    }
                } else {
                    this.f67265c.setIsNoTitle(false);
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.f67265c.setIsNoTitle(true);
            } else {
                this.f67265c.setIsNoTitle(false);
            }
            if (str == null && str.length() > 0 && this.w) {
                this.f67271i.setEnabled(true);
                return;
            } else {
                this.f67271i.setEnabled(false);
            }
        }
        str = null;
        if (str == null) {
        }
        this.f67271i.setEnabled(false);
    }

    public void B(View.OnFocusChangeListener onFocusChangeListener) {
        this.f67266d.setOnFocusChangeListener(onFocusChangeListener);
        this.f67270h.setOnFocusChangeListener(onFocusChangeListener);
        this.f67264b.setOnFocusChangeListener(onFocusChangeListener);
        this.f67271i.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void C(View.OnClickListener onClickListener) {
        this.f67264b.setOnClickListener(onClickListener);
    }

    public void D(View.OnClickListener onClickListener) {
        this.f67271i.setOnClickListener(onClickListener);
    }

    public void E(View.OnClickListener onClickListener) {
        this.f67269g.setOnClickListener(onClickListener);
    }

    public void F(PostPrefixData postPrefixData) {
        this.k = postPrefixData;
        u();
    }

    public final void m(EditText editText, int i2) {
        Editable text = editText.getText();
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        editText.setText((CharSequence) null);
        editText.setHintTextColor(i2);
        editText.setText(text);
        editText.setSelection(selectionStart, selectionEnd);
    }

    public View n() {
        return this.f67264b;
    }

    public TextView o() {
        return this.f67271i;
    }

    public EditText p() {
        return this.f67270h;
    }

    public EditText q() {
        return this.f67266d;
    }

    public TextView r() {
        return this.l;
    }

    public d.a.o0.w3.h s() {
        return this.m;
    }

    public ShareSDKImageView t() {
        return this.r;
    }

    public final void u() {
        this.o = this.u.findViewById(R.id.post_prefix_layout);
        this.l = (TextView) this.u.findViewById(R.id.post_prefix);
        this.n = (ImageView) this.u.findViewById(R.id.prefix_icon);
        PostPrefixData postPrefixData = this.k;
        if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
            this.o.setVisibility(0);
            ArrayList<String> prefixs = this.k.getPrefixs();
            int size = prefixs.size();
            this.l.setText(prefixs.get(0));
            this.u.setCurrentPrefixPosition(0);
            this.o.setOnClickListener(new View$OnClickListenerC1812c());
            ImageView imageView = (ImageView) this.u.findViewById(R.id.prefix_icon);
            this.n = imageView;
            if (size > 1) {
                imageView.setVisibility(0);
                this.l.setOnClickListener(new d());
            }
            d.a.o0.w3.h hVar = new d.a.o0.w3.h(this.u.getPageContext().getContext());
            this.m = hVar;
            hVar.d(l.e(this.u.getPageContext().getContext(), 225.0f));
            this.m.setOutsideTouchable(true);
            this.m.setFocusable(true);
            this.m.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0204));
            this.m.e(new e());
            this.m.setOnDismissListener(new f());
            int color = SkinManager.getColor(R.color.common_color_10097);
            SkinManager.setBackgroundResource(this.l, R.drawable.write_prefix_item_selector);
            SkinManager.setImageResource(this.n, R.drawable.icon_title_down);
            this.l.setTextColor(color);
            for (int i2 = 0; i2 < size; i2++) {
                TextView textView = new TextView(this.u.getPageContext().getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, l.e(this.u.getPageContext().getContext(), 45.0f));
                textView.setLayoutParams(layoutParams);
                textView.setText(prefixs.get(i2));
                textView.setGravity(19);
                textView.setSingleLine();
                textView.setEllipsize(TextUtils.TruncateAt.MIDDLE);
                textView.setTextSize(1, 16.0f);
                textView.setTextColor(color);
                SkinManager.setBackgroundResource(textView, R.drawable.write_prefix_item_selector);
                textView.setPadding(l.e(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds6)), 0, l.e(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds22)), 0);
                this.m.a(textView);
                if (i2 != size - 1) {
                    layoutParams.bottomMargin = l.e(this.u.getPageContext().getContext(), 1.0f);
                    textView.setGravity(19);
                    textView.setPadding(l.e(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds6)), 0, l.e(this.u.getPageContext().getContext(), this.u.getResources().getDimension(R.dimen.ds22)), 0);
                }
            }
            this.m.c(0);
            return;
        }
        this.o.setVisibility(8);
    }

    public void v() {
        this.p = (LinearLayout) this.u.findViewById(R.id.post_share_layout);
        ShareSDKImageView shareSDKImageView = (ShareSDKImageView) this.u.findViewById(R.id.post_share_image);
        this.r = shareSDKImageView;
        shareSDKImageView.setIsRound(false);
        this.r.setDrawBorder(false);
        this.r.setAutoChangeStyle(true);
        this.r.setRadius(0);
        this.s = (TextView) this.u.findViewById(R.id.post_share_title);
        this.t = (TextView) this.u.findViewById(R.id.post_share_content);
        WriteData writeData = this.f67265c;
        if (writeData != null) {
            if (writeData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.r.setEvent(new a());
            }
            if (this.f67265c.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.f67265c.getShareSummaryImg() != null && this.f67265c.getShareSummaryImg().trim().length() > 0) {
                    this.r.U(this.f67265c.getShareSummaryImg(), 10, true);
                } else {
                    this.w = true;
                    A();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f67265c.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.r.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.f67265c.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f67265c.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.a.n0.b0.g.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
                    this.r.setTag(imageFileInfo.toCachedKey(true));
                    if (this.v.d(imageFileInfo, new b(), true) != null) {
                        this.r.invalidate();
                    }
                }
                this.w = true;
                A();
            }
            WriteData writeData2 = this.f67265c;
            writeData2.setShareSummaryImgType(d.a.c.e.p.f.s(writeData2.getShareSummaryImg()));
            this.s.setText(this.f67265c.getShareSummaryTitle());
            this.t.setText(this.f67265c.getShareSummaryContent());
        }
    }

    public final void w() {
        NavigationBar navigationBar = (NavigationBar) this.u.findViewById(R.id.view_navigation_bar);
        this.f67263a = navigationBar;
        this.f67264b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f67263a.setTitleText(this.u.getPageContext().getString(R.string.share_navigationbar_title));
        this.f67271i = this.f67263a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.u.getPageContext().getString(R.string.send_post));
        this.j = (RelativeLayout) this.u.findViewById(R.id.parent);
        this.f67267e = this.u.findViewById(R.id.interval_view);
        this.f67268f = this.u.findViewById(R.id.prefix_interval_view);
        this.p = (LinearLayout) this.u.findViewById(R.id.post_share_layout);
        this.q = (LinearLayout) this.u.findViewById(R.id.post_share_content_layout);
        this.r = (ShareSDKImageView) this.u.findViewById(R.id.post_share_image);
        this.s = (TextView) this.u.findViewById(R.id.post_share_title);
        this.t = (TextView) this.u.findViewById(R.id.post_share_content);
        y();
        x();
        LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.post_content_container);
        this.f67269g = linearLayout;
        linearLayout.setDrawingCacheEnabled(false);
        this.f67266d.setVisibility(0);
        this.f67270h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        A();
    }

    public void x() {
        EditText editText = (EditText) this.u.findViewById(R.id.post_content);
        this.f67270h = editText;
        editText.setDrawingCacheEnabled(false);
        if (this.f67265c.getContent() != null && this.f67265c.getContent().length() > 0) {
            SpannableString j = TbFaceManager.e().j(this.u.getPageContext().getContext(), this.f67265c.getContent());
            this.f67270h.setText(j);
            this.f67270h.setSelection(j.length());
        }
        this.f67270h.setOnTouchListener(new h(this));
        this.f67270h.addTextChangedListener(new i());
    }

    public void y() {
        this.f67266d = (EditText) this.u.findViewById(R.id.post_title);
        if (this.f67265c.getType() == 3) {
            if (this.f67265c.getTitle() != null && this.f67265c.getTitle().trim().length() > 0) {
                this.f67266d.setText(this.f67265c.getTitle());
                this.f67266d.setSelection(this.f67265c.getTitle().length());
            } else {
                String str = this.u.getPageContext().getString(R.string.share_transfer_thread) + this.f67265c.getShareSummaryTitle();
                this.f67266d.setText(str);
                if (str.length() < 20) {
                    this.f67266d.setSelection(str.length());
                } else {
                    this.f67266d.setSelection(20);
                }
            }
        }
        this.f67266d.addTextChangedListener(new g());
    }

    public void z(int i2) {
        WriteShareActivity writeShareActivity = this.u;
        if (writeShareActivity == null) {
            return;
        }
        writeShareActivity.getLayoutMode().k(i2 == 1);
        this.u.getLayoutMode().j(this.j);
        this.f67263a.onChangeSkinType(this.u.getPageContext(), i2);
        SkinManager.setTopBarCommonFinishButton(this.f67271i, i2);
        SkinManager.setBackgroundColor(this.f67267e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f67268f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f67266d, R.color.CAM_X0111);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
        int color = SkinManager.getColor(R.color.CAM_X0105);
        int color2 = SkinManager.getColor(R.color.CAM_X0110);
        this.f67266d.setTextColor(color);
        this.f67270h.setTextColor(color);
        this.s.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        m(this.f67266d, color2);
        m(this.f67270h, color2);
        A();
    }
}
