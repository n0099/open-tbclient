package com.kwad.sdk.emotion.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.TextView;
/* loaded from: classes6.dex */
public class EmojiTextView extends TextView {

    /* renamed from: a  reason: collision with root package name */
    public e f34690a;

    /* renamed from: b  reason: collision with root package name */
    public a f34691b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f34692c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f34693d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f34694e;

    /* loaded from: classes6.dex */
    public interface a {
        void a(EmojiTextView emojiTextView, boolean z);
    }

    public EmojiTextView(Context context) {
        super(context);
        this.f34692c = false;
        this.f34693d = false;
        this.f34694e = false;
        a();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34692c = false;
        this.f34693d = false;
        this.f34694e = false;
        a();
    }

    public EmojiTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34692c = false;
        this.f34693d = false;
        this.f34694e = false;
        a();
    }

    private void a() {
        this.f34690a = new d(this);
        addTextChangedListener(new TextWatcher() { // from class: com.kwad.sdk.emotion.widget.EmojiTextView.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                EmojiTextView emojiTextView = EmojiTextView.this;
                if (emojiTextView.f34690a == null) {
                    return;
                }
                if (emojiTextView.f34692c) {
                    if (EmojiTextView.this.f34694e || TextUtils.isEmpty(EmojiTextView.this.getEditableText())) {
                        if (EmojiTextView.this.f34693d) {
                            return;
                        }
                        EmojiTextView emojiTextView2 = EmojiTextView.this;
                        emojiTextView2.f34690a.a(emojiTextView2.getEditableText());
                        if (EmojiTextView.this.f34692c) {
                            EmojiTextView.this.f34693d = true;
                            return;
                        }
                        return;
                    }
                    EmojiTextView.this.f34694e = true;
                }
                EmojiTextView emojiTextView3 = EmojiTextView.this;
                emojiTextView3.f34690a.a(emojiTextView3.getEditableText());
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        });
        if (getText() == null || getText().length() <= 0) {
            return;
        }
        this.f34690a.a(getEditableText());
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i, int i2) {
        try {
            super.append(charSequence, i, i2);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.a.a(th);
        }
    }

    public e getKSTextDisplayHandler() {
        return this.f34690a;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        CharSequence text = super.getText();
        return text == null ? "" : text;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (IndexOutOfBoundsException unused) {
            setText(getText().toString());
            try {
                super.onMeasure(i, i2);
            } catch (IndexOutOfBoundsException unused2) {
                setText("");
                super.onMeasure(i, i2);
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
        this.f34693d = true;
        super.postInvalidate();
    }

    public void setKSTextDisplayHandler(e eVar) {
        this.f34690a = eVar;
    }

    public void setOnPressedListener(a aVar) {
        this.f34691b = aVar;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        a aVar;
        boolean isPressed = isPressed();
        super.setPressed(z);
        if (!(isPressed ^ z) || (aVar = this.f34691b) == null) {
            return;
        }
        aVar.a(this, z);
    }

    public void setPreventDeadCycleInvalidate(boolean z) {
        this.f34692c = z;
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
