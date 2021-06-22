package com.kwad.sdk.emotion.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes7.dex */
public class EmojiTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public e f35445a;

    /* renamed from: b  reason: collision with root package name */
    public a f35446b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35447c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f35448d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f35449e;

    /* loaded from: classes7.dex */
    public interface a {
        void a(EmojiTextView emojiTextView, boolean z);
    }

    public EmojiTextView(Context context) {
        super(context);
        this.f35447c = false;
        this.f35448d = false;
        this.f35449e = false;
        a();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35447c = false;
        this.f35448d = false;
        this.f35449e = false;
        a();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f35447c = false;
        this.f35448d = false;
        this.f35449e = false;
        a();
    }

    private void a() {
        this.f35445a = new d(this);
        addTextChangedListener(new TextWatcher() { // from class: com.kwad.sdk.emotion.widget.EmojiTextView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EmojiTextView emojiTextView = EmojiTextView.this;
                if (emojiTextView.f35445a == null) {
                    return;
                }
                if (emojiTextView.f35447c) {
                    if (EmojiTextView.this.f35449e || TextUtils.isEmpty(EmojiTextView.this.getEditableText())) {
                        if (EmojiTextView.this.f35448d) {
                            return;
                        }
                        EmojiTextView emojiTextView2 = EmojiTextView.this;
                        emojiTextView2.f35445a.a(emojiTextView2.getEditableText());
                        if (EmojiTextView.this.f35447c) {
                            EmojiTextView.this.f35448d = true;
                            return;
                        }
                        return;
                    }
                    EmojiTextView.this.f35449e = true;
                }
                EmojiTextView emojiTextView3 = EmojiTextView.this;
                emojiTextView3.f35445a.a(emojiTextView3.getEditableText());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
        if (getText() == null || getText().length() <= 0) {
            return;
        }
        this.f35445a.a(getEditableText());
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i2, int i3) {
        try {
            super.append(charSequence, i2, i3);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public e getKSTextDisplayHandler() {
        return this.f35445a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        CharSequence text = super.getText();
        return text == null ? "" : text;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i2, int i3) {
        try {
            super.onMeasure(i2, i3);
        } catch (IndexOutOfBoundsException unused) {
            setText(getText().toString());
            try {
                super.onMeasure(i2, i3);
            } catch (IndexOutOfBoundsException unused2) {
                setText("");
                super.onMeasure(i2, i3);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean performLongClick() {
        try {
            return super.performLongClick();
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // android.view.View
    public void postInvalidate() {
        this.f35448d = true;
        super.postInvalidate();
    }

    public void setKSTextDisplayHandler(e eVar) {
        this.f35445a = eVar;
    }

    public void setOnPressedListener(a aVar) {
        this.f35446b = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        a aVar;
        boolean isPressed = isPressed();
        super.setPressed(z);
        if (!(isPressed ^ z) || (aVar = this.f35446b) == null) {
            return;
        }
        aVar.a(this, z);
    }

    public void setPreventDeadCycleInvalidate(boolean z) {
        this.f35447c = z;
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        try {
            super.setText(charSequence, bufferType);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }
}
