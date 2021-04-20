package d.b.i0.x2;

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
import d.b.c.e.p.l;
import d.b.i0.v3.i;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes4.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public WriteData f63962c;

    /* renamed from: f  reason: collision with root package name */
    public View f63965f;
    public PostPrefixData k;
    public TextView l;
    public d.b.i0.v3.i m;
    public ImageView n;
    public View o;
    public LinearLayout p;
    public LinearLayout q;
    public ShareSDKImageView r;
    public TextView s;
    public TextView t;
    public WriteShareActivity u;
    public d.b.h0.b0.b v;

    /* renamed from: a  reason: collision with root package name */
    public NavigationBar f63960a = null;

    /* renamed from: b  reason: collision with root package name */
    public View f63961b = null;

    /* renamed from: d  reason: collision with root package name */
    public EditText f63963d = null;

    /* renamed from: e  reason: collision with root package name */
    public View f63964e = null;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f63966g = null;

    /* renamed from: h  reason: collision with root package name */
    public EditText f63967h = null;
    public TextView i = null;
    public RelativeLayout j = null;
    public boolean w = false;
    public int x = 0;
    public int y = 0;

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class b implements d.b.h0.a0.b {
        public b() {
        }

        @Override // d.b.h0.a0.b
        public void a(d.b.c.j.d.a aVar, String str, boolean z) {
            TbImageView tbImageView = (TbImageView) c.this.p.findViewWithTag(str);
            if (tbImageView == null || aVar == null) {
                return;
            }
            tbImageView.invalidate();
        }
    }

    /* renamed from: d.b.i0.x2.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class View$OnClickListenerC1710c implements View.OnClickListener {
        public View$OnClickListenerC1710c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.l.setVisibility(0);
            c.this.o.setSelected(true);
            d.b.c.e.m.g.l(c.this.m, view, l.e(c.this.u.getPageContext().getContext(), 15.0f), l.e(c.this.u.getPageContext().getContext(), 1.0f));
            if (c.this.u != null) {
                c.this.u.hidenSoftKeyPad();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c.this.l.setSelected(true);
            d.b.c.e.m.g.l(c.this.m, view, l.e(c.this.u.getPageContext().getContext(), 15.0f), l.e(c.this.u.getPageContext().getContext(), 1.0f));
            if (c.this.u != null) {
                c.this.u.hidenSoftKeyPad();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements i.a {
        public e() {
        }

        @Override // d.b.i0.v3.i.a
        public void onPrefixItemClick(int i) {
            c.this.u.setCurrentPrefixPosition(i);
            c.this.l.setText(c.this.k.getPrefixs().get(i));
            c.this.m.c(i);
            c.this.A();
            d.b.c.e.m.g.d(c.this.m, c.this.u.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes4.dex */
    public class f implements PopupWindow.OnDismissListener {
        public f() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            c.this.o.setSelected(false);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements TextWatcher {
        public g() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.this.A();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public class i implements TextWatcher {
        public i() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            c.this.A();
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public c(WriteShareActivity writeShareActivity) {
        this.f63962c = null;
        this.u = writeShareActivity;
        this.f63962c = writeShareActivity.getWriteData();
        if (this.v == null) {
            this.v = new d.b.h0.b0.b();
        }
        w();
    }

    public void A() {
        String str = "1";
        if (this.f63962c.getType() == 3) {
            String trim = this.f63963d.getText().toString().trim();
            PostPrefixData postPrefixData = this.k;
            if (postPrefixData != null && postPrefixData.getPrefixs().size() > 0) {
                if (this.u.getCurrentPrefixPosition() == this.k.getPrefixs().size() - 1) {
                    if (TextUtils.isEmpty(trim)) {
                        this.f63962c.setIsNoTitle(true);
                    } else {
                        this.f63962c.setIsNoTitle(false);
                    }
                } else {
                    this.f63962c.setIsNoTitle(false);
                }
            } else if (TextUtils.isEmpty(trim)) {
                this.f63962c.setIsNoTitle(true);
            } else {
                this.f63962c.setIsNoTitle(false);
            }
            if (str == null && str.length() > 0 && this.w) {
                this.i.setEnabled(true);
                return;
            } else {
                this.i.setEnabled(false);
            }
        }
        str = null;
        if (str == null) {
        }
        this.i.setEnabled(false);
    }

    public void B(View.OnFocusChangeListener onFocusChangeListener) {
        this.f63963d.setOnFocusChangeListener(onFocusChangeListener);
        this.f63967h.setOnFocusChangeListener(onFocusChangeListener);
        this.f63961b.setOnFocusChangeListener(onFocusChangeListener);
        this.i.setOnFocusChangeListener(onFocusChangeListener);
    }

    public void C(View.OnClickListener onClickListener) {
        this.f63961b.setOnClickListener(onClickListener);
    }

    public void D(View.OnClickListener onClickListener) {
        this.i.setOnClickListener(onClickListener);
    }

    public void E(View.OnClickListener onClickListener) {
        this.f63966g.setOnClickListener(onClickListener);
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
        return this.f63961b;
    }

    public TextView o() {
        return this.i;
    }

    public EditText p() {
        return this.f63967h;
    }

    public EditText q() {
        return this.f63963d;
    }

    public TextView r() {
        return this.l;
    }

    public d.b.i0.v3.i s() {
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
            this.o.setOnClickListener(new View$OnClickListenerC1710c());
            ImageView imageView = (ImageView) this.u.findViewById(R.id.prefix_icon);
            this.n = imageView;
            if (size > 1) {
                imageView.setVisibility(0);
                this.l.setOnClickListener(new d());
            }
            d.b.i0.v3.i iVar = new d.b.i0.v3.i(this.u.getPageContext().getContext());
            this.m = iVar;
            iVar.d(l.e(this.u.getPageContext().getContext(), 225.0f));
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
        WriteData writeData = this.f63962c;
        if (writeData != null) {
            if (writeData.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                this.r.setEvent(new a());
            }
            if (this.f63962c.getShareImageType() == WriteData.SHARE_SDK_NET_IMAGE) {
                if (this.f63962c.getShareSummaryImg() != null && this.f63962c.getShareSummaryImg().trim().length() > 0) {
                    this.r.W(this.f63962c.getShareSummaryImg(), 10, true);
                } else {
                    this.w = true;
                    A();
                }
            } else {
                Bitmap Bytes2Bitmap = BitmapHelper.Bytes2Bitmap(this.f63962c.getShareLocalImageData());
                if (Bytes2Bitmap != null) {
                    this.r.setImageBitmap(Bytes2Bitmap);
                } else {
                    ImageFileInfo imageFileInfo = new ImageFileInfo();
                    if (!TextUtils.isEmpty(this.f63962c.getShareLocalImageUri())) {
                        imageFileInfo.setFilePath(FileHelper.getImageRealPathFromUri(TbadkCoreApplication.getInst().getApp(), Uri.parse(this.f63962c.getShareLocalImageUri())));
                    }
                    imageFileInfo.clearAllActions();
                    imageFileInfo.addPersistAction(d.b.h0.b0.g.d.g(TbImageHelper.getInstance().getPostImageSize(), TbImageHelper.getInstance().getPostImageHeightLimit()));
                    this.r.setTag(imageFileInfo.toCachedKey(true));
                    if (this.v.d(imageFileInfo, new b(), true) != null) {
                        this.r.invalidate();
                    }
                }
                this.w = true;
                A();
            }
            WriteData writeData2 = this.f63962c;
            writeData2.setShareSummaryImgType(d.b.c.e.p.f.s(writeData2.getShareSummaryImg()));
            this.s.setText(this.f63962c.getShareSummaryTitle());
            this.t.setText(this.f63962c.getShareSummaryContent());
        }
    }

    public final void w() {
        NavigationBar navigationBar = (NavigationBar) this.u.findViewById(R.id.view_navigation_bar);
        this.f63960a = navigationBar;
        this.f63961b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f63960a.setTitleText(this.u.getPageContext().getString(R.string.share_navigationbar_title));
        this.i = this.f63960a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.u.getPageContext().getString(R.string.send_post));
        this.j = (RelativeLayout) this.u.findViewById(R.id.parent);
        this.f63964e = this.u.findViewById(R.id.interval_view);
        this.f63965f = this.u.findViewById(R.id.prefix_interval_view);
        this.p = (LinearLayout) this.u.findViewById(R.id.post_share_layout);
        this.q = (LinearLayout) this.u.findViewById(R.id.post_share_content_layout);
        this.r = (ShareSDKImageView) this.u.findViewById(R.id.post_share_image);
        this.s = (TextView) this.u.findViewById(R.id.post_share_title);
        this.t = (TextView) this.u.findViewById(R.id.post_share_content);
        y();
        x();
        LinearLayout linearLayout = (LinearLayout) this.u.findViewById(R.id.post_content_container);
        this.f63966g = linearLayout;
        linearLayout.setDrawingCacheEnabled(false);
        this.f63963d.setVisibility(0);
        this.f63967h.setFilters(new InputFilter[]{new InputFilter.LengthFilter(2000)});
        A();
    }

    public void x() {
        EditText editText = (EditText) this.u.findViewById(R.id.post_content);
        this.f63967h = editText;
        editText.setDrawingCacheEnabled(false);
        if (this.f63962c.getContent() != null && this.f63962c.getContent().length() > 0) {
            SpannableString j = TbFaceManager.e().j(this.u.getPageContext().getContext(), this.f63962c.getContent());
            this.f63967h.setText(j);
            this.f63967h.setSelection(j.length());
        }
        this.f63967h.setOnTouchListener(new h(this));
        this.f63967h.addTextChangedListener(new i());
    }

    public void y() {
        this.f63963d = (EditText) this.u.findViewById(R.id.post_title);
        if (this.f63962c.getType() == 3) {
            if (this.f63962c.getTitle() != null && this.f63962c.getTitle().trim().length() > 0) {
                this.f63963d.setText(this.f63962c.getTitle());
                this.f63963d.setSelection(this.f63962c.getTitle().length());
            } else {
                String str = this.u.getPageContext().getString(R.string.share_transfer_thread) + this.f63962c.getShareSummaryTitle();
                this.f63963d.setText(str);
                if (str.length() < 20) {
                    this.f63963d.setSelection(str.length());
                } else {
                    this.f63963d.setSelection(20);
                }
            }
        }
        this.f63963d.addTextChangedListener(new g());
    }

    public void z(int i2) {
        WriteShareActivity writeShareActivity = this.u;
        if (writeShareActivity == null) {
            return;
        }
        writeShareActivity.getLayoutMode().k(i2 == 1);
        this.u.getLayoutMode().j(this.j);
        this.f63960a.onChangeSkinType(this.u.getPageContext(), i2);
        SkinManager.setTopBarCommonFinishButton(this.i, i2);
        SkinManager.setBackgroundColor(this.f63964e, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f63965f, R.color.CAM_X0204);
        SkinManager.setBackgroundColor(this.f63963d, R.color.CAM_X0111);
        SkinManager.setBackgroundColor(this.q, R.color.CAM_X0205);
        int color = SkinManager.getColor(R.color.CAM_X0105);
        int color2 = SkinManager.getColor(R.color.CAM_X0110);
        this.f63963d.setTextColor(color);
        this.f63967h.setTextColor(color);
        this.s.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
        this.t.setTextColor(SkinManager.getColor(R.color.CAM_X0109));
        m(this.f63963d, color2);
        m(this.f63967h, color2);
        A();
    }
}
