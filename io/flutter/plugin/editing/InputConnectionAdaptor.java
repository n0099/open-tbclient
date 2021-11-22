package io.flutter.plugin.editing;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import android.provider.Settings;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.datacollector.growth.utils.GrowthConstant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.internal.ManufacturerUtils;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
/* loaded from: classes2.dex */
public class InputConnectionAdaptor extends BaseInputConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean isSamsung;
    public int mBatchCount;
    public final int mClient;
    public final Editable mEditable;
    public final EditorInfo mEditorInfo;
    public final View mFlutterView;
    public InputMethodManager mImm;
    public final Layout mLayout;
    public final TextInputChannel textInputChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputConnectionAdaptor(View view, int i2, TextInputChannel textInputChannel, Editable editable, EditorInfo editorInfo) {
        super(view, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), textInputChannel, editable, editorInfo};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((View) objArr2[0], ((Boolean) objArr2[1]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mFlutterView = view;
        this.mClient = i2;
        this.textInputChannel = textInputChannel;
        this.mEditable = editable;
        this.mEditorInfo = editorInfo;
        this.mBatchCount = 0;
        this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
        this.isSamsung = isSamsung();
    }

    public static int clampIndexToEditable(int i2, Editable editable) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65537, null, i2, editable)) == null) {
            int max = Math.max(0, Math.min(editable.length(), i2));
            if (max != i2) {
                Log.d("flutter", "Text selection index was clamped (" + i2 + "->" + max + ") to remain in bounds. This may not be your fault, as some keyboards may select outside of bounds.");
            }
            return max;
        }
        return invokeIL.intValue;
    }

    @SuppressLint({"NewApi"})
    private boolean isSamsung() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, this)) == null) {
            if (this.mImm.getCurrentInputMethodSubtype() == null || Build.VERSION.SDK_INT < 21 || !Build.MANUFACTURER.equals(ManufacturerUtils.SAMSUNG)) {
                return false;
            }
            return Settings.Secure.getString(this.mFlutterView.getContext().getContentResolver(), "default_input_method").contains("Samsung");
        }
        return invokeV.booleanValue;
    }

    private void updateEditingState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65539, this) == null) || this.mBatchCount > 0) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this.mEditable);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this.mEditable);
        this.mImm.updateSelection(this.mFlutterView, selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
        this.textInputChannel.updateEditingState(this.mClient, this.mEditable.toString(), selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            this.mBatchCount++;
            return super.beginBatchEdit();
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i2)) == null) {
            boolean commitText = super.commitText(charSequence, i2);
            updateEditingState();
            return commitText;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(Constants.METHOD_SEND_USER_MSG, this, i2, i3)) == null) {
            if (Selection.getSelectionStart(this.mEditable) == -1) {
                return true;
            }
            boolean deleteSurroundingText = super.deleteSurroundingText(i2, i3);
            updateEditingState();
            return deleteSurroundingText;
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            boolean endBatchEdit = super.endBatchEdit();
            this.mBatchCount--;
            updateEditingState();
            return endBatchEdit;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            boolean finishComposingText = super.finishComposingText();
            if (this.isSamsung && Build.VERSION.SDK_INT >= 21) {
                CursorAnchorInfo.Builder builder = new CursorAnchorInfo.Builder();
                builder.setComposingText(-1, "");
                this.mImm.updateCursorAnchorInfo(this.mFlutterView, builder.build());
            }
            updateEditingState();
            return finishComposingText;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mEditable : (Editable) invokeV.objValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) {
            if (i2 == 16908319) {
                setSelection(0, this.mEditable.length());
                return true;
            } else if (i2 == 16908320) {
                int selectionStart = Selection.getSelectionStart(this.mEditable);
                int selectionEnd = Selection.getSelectionEnd(this.mEditable);
                if (selectionStart != selectionEnd) {
                    int min = Math.min(selectionStart, selectionEnd);
                    int max = Math.max(selectionStart, selectionEnd);
                    ((ClipboardManager) this.mFlutterView.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(min, max)));
                    this.mEditable.delete(min, max);
                    setSelection(min, min);
                }
                return true;
            } else if (i2 == 16908321) {
                int selectionStart2 = Selection.getSelectionStart(this.mEditable);
                int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
                if (selectionStart2 != selectionEnd2) {
                    ((ClipboardManager) this.mFlutterView.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).setPrimaryClip(ClipData.newPlainText("text label?", this.mEditable.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
                }
                return true;
            } else if (i2 == 16908322) {
                ClipData primaryClip = ((ClipboardManager) this.mFlutterView.getContext().getSystemService(GrowthConstant.UBC_VALUE_TYPE_CLIP_BOARD)).getPrimaryClip();
                if (primaryClip != null) {
                    CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.mFlutterView.getContext());
                    int max2 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                    int max3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                    int min2 = Math.min(max2, max3);
                    int max4 = Math.max(max2, max3);
                    if (min2 != max4) {
                        this.mEditable.delete(min2, max4);
                    }
                    this.mEditable.insert(min2, coerceToText);
                    int length = min2 + coerceToText.length();
                    setSelection(length, length);
                }
                return true;
            } else {
                return false;
            }
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 == 0) {
                this.textInputChannel.unspecifiedAction(this.mClient);
            } else if (i2 == 1) {
                this.textInputChannel.newline(this.mClient);
            } else if (i2 == 2) {
                this.textInputChannel.go(this.mClient);
            } else if (i2 == 3) {
                this.textInputChannel.search(this.mClient);
            } else if (i2 == 4) {
                this.textInputChannel.send(this.mClient);
            } else if (i2 == 5) {
                this.textInputChannel.next(this.mClient);
            } else if (i2 != 7) {
                this.textInputChannel.done(this.mClient);
            } else {
                this.textInputChannel.previous(this.mClient);
            }
            return true;
        }
        return invokeI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, keyEvent)) == null) {
            if (keyEvent.getAction() == 0) {
                if (keyEvent.getKeyCode() == 67) {
                    int clampIndexToEditable = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
                    int clampIndexToEditable2 = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
                    if (clampIndexToEditable2 > clampIndexToEditable) {
                        Selection.setSelection(this.mEditable, clampIndexToEditable);
                        this.mEditable.delete(clampIndexToEditable, clampIndexToEditable2);
                        updateEditingState();
                        return true;
                    } else if (clampIndexToEditable > 0) {
                        Layout layout = this.mLayout;
                        try {
                            if (layout.isRtlCharAt(layout.getLineForOffset(clampIndexToEditable))) {
                                Selection.extendRight(this.mEditable, this.mLayout);
                            } else {
                                Selection.extendLeft(this.mEditable, this.mLayout);
                            }
                        } catch (IndexOutOfBoundsException unused) {
                            Selection.setSelection(this.mEditable, clampIndexToEditable, clampIndexToEditable - 1);
                        }
                        int clampIndexToEditable3 = clampIndexToEditable(Selection.getSelectionStart(this.mEditable), this.mEditable);
                        int clampIndexToEditable4 = clampIndexToEditable(Selection.getSelectionEnd(this.mEditable), this.mEditable);
                        Selection.setSelection(this.mEditable, Math.min(clampIndexToEditable3, clampIndexToEditable4));
                        this.mEditable.delete(Math.min(clampIndexToEditable3, clampIndexToEditable4), Math.max(clampIndexToEditable3, clampIndexToEditable4));
                        updateEditingState();
                        return true;
                    }
                } else if (keyEvent.getKeyCode() == 21) {
                    int selectionStart = Selection.getSelectionStart(this.mEditable);
                    int selectionEnd = Selection.getSelectionEnd(this.mEditable);
                    if (selectionStart == selectionEnd && !keyEvent.isShiftPressed()) {
                        int max = Math.max(selectionStart - 1, 0);
                        setSelection(max, max);
                    } else {
                        setSelection(selectionStart, Math.max(selectionEnd - 1, 0));
                    }
                    return true;
                } else if (keyEvent.getKeyCode() == 22) {
                    int selectionStart2 = Selection.getSelectionStart(this.mEditable);
                    int selectionEnd2 = Selection.getSelectionEnd(this.mEditable);
                    if (selectionStart2 == selectionEnd2 && !keyEvent.isShiftPressed()) {
                        int min = Math.min(selectionStart2 + 1, this.mEditable.length());
                        setSelection(min, min);
                    } else {
                        setSelection(selectionStart2, Math.min(selectionEnd2 + 1, this.mEditable.length()));
                    }
                    return true;
                } else if (keyEvent.getKeyCode() == 19) {
                    if (Selection.getSelectionStart(this.mEditable) == Selection.getSelectionEnd(this.mEditable) && !keyEvent.isShiftPressed()) {
                        Selection.moveUp(this.mEditable, this.mLayout);
                        int selectionStart3 = Selection.getSelectionStart(this.mEditable);
                        setSelection(selectionStart3, selectionStart3);
                    } else {
                        Selection.extendUp(this.mEditable, this.mLayout);
                        setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
                    }
                    return true;
                } else if (keyEvent.getKeyCode() == 20) {
                    if (Selection.getSelectionStart(this.mEditable) == Selection.getSelectionEnd(this.mEditable) && !keyEvent.isShiftPressed()) {
                        Selection.moveDown(this.mEditable, this.mLayout);
                        int selectionStart4 = Selection.getSelectionStart(this.mEditable);
                        setSelection(selectionStart4, selectionStart4);
                    } else {
                        Selection.extendDown(this.mEditable, this.mLayout);
                        setSelection(Selection.getSelectionStart(this.mEditable), Selection.getSelectionEnd(this.mEditable));
                    }
                    return true;
                } else {
                    if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
                        EditorInfo editorInfo = this.mEditorInfo;
                        if ((131072 & editorInfo.inputType) == 0) {
                            performEditorAction(editorInfo.imeOptions & 255);
                            return true;
                        }
                    }
                    int unicodeChar = keyEvent.getUnicodeChar();
                    if (unicodeChar != 0) {
                        int max2 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                        int max3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                        int min2 = Math.min(max2, max3);
                        int max4 = Math.max(max2, max3);
                        if (min2 != max4) {
                            this.mEditable.delete(min2, max4);
                        }
                        this.mEditable.insert(min2, String.valueOf((char) unicodeChar));
                        int i2 = min2 + 1;
                        setSelection(i2, i2);
                    }
                    return true;
                }
            }
            if (keyEvent.getAction() == 1 && (keyEvent.getKeyCode() == 59 || keyEvent.getKeyCode() == 60)) {
                int selectionEnd3 = Selection.getSelectionEnd(this.mEditable);
                setSelection(selectionEnd3, selectionEnd3);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            boolean composingRegion = super.setComposingRegion(i2, i3);
            updateEditingState();
            return composingRegion;
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i2) {
        InterceptResult invokeLI;
        boolean composingText;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, charSequence, i2)) == null) {
            if (charSequence.length() == 0) {
                composingText = super.commitText(charSequence, i2);
            } else {
                composingText = super.setComposingText(charSequence, i2);
            }
            updateEditingState();
            return composingText;
        }
        return invokeLI.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            boolean selection = super.setSelection(i2, i3);
            updateEditingState();
            return selection;
        }
        return invokeII.booleanValue;
    }
}
