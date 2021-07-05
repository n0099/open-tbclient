package com.idlefish.flutterboost;

import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.InputMethodManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
/* loaded from: classes7.dex */
public class XInputConnectionAdaptor extends BaseInputConnection {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mBatchCount;
    public final int mClient;
    public final Editable mEditable;
    public final View mFlutterView;
    public InputMethodManager mImm;
    public final Layout mLayout;
    public final TextInputChannel textInputChannel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XInputConnectionAdaptor(View view, int i2, TextInputChannel textInputChannel, Editable editable) {
        super(view, true);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, Integer.valueOf(i2), textInputChannel, editable};
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
        this.mBatchCount = 0;
        this.mLayout = new DynamicLayout(this.mEditable, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.mImm = (InputMethodManager) view.getContext().getSystemService("input_method");
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

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mEditable : (Editable) invokeV.objValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) {
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
                    int max = Math.max(Selection.getSelectionStart(this.mEditable) - 1, 0);
                    setSelection(max, max);
                    return true;
                } else if (keyEvent.getKeyCode() == 22) {
                    int min = Math.min(Selection.getSelectionStart(this.mEditable) + 1, this.mEditable.length());
                    setSelection(min, min);
                    return true;
                } else {
                    int unicodeChar = keyEvent.getUnicodeChar();
                    if (unicodeChar != 0) {
                        int max2 = Math.max(0, Selection.getSelectionStart(this.mEditable));
                        int max3 = Math.max(0, Selection.getSelectionEnd(this.mEditable));
                        if (max3 != max2) {
                            this.mEditable.delete(max2, max3);
                        }
                        this.mEditable.insert(max2, String.valueOf((char) unicodeChar));
                        int i2 = max2 + 1;
                        setSelection(i2, i2);
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048583, this, i2, i3)) == null) {
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
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, charSequence, i2)) == null) {
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
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            boolean selection = super.setSelection(i2, i3);
            updateEditingState();
            return selection;
        }
        return invokeII.booleanValue;
    }

    public final void updateEditingState() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || this.mBatchCount > 0) {
            return;
        }
        int selectionStart = Selection.getSelectionStart(this.mEditable);
        int selectionEnd = Selection.getSelectionEnd(this.mEditable);
        int composingSpanStart = BaseInputConnection.getComposingSpanStart(this.mEditable);
        int composingSpanEnd = BaseInputConnection.getComposingSpanEnd(this.mEditable);
        this.mImm.updateSelection(this.mFlutterView, selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
        this.textInputChannel.updateEditingState(this.mClient, this.mEditable.toString(), selectionStart, selectionEnd, composingSpanStart, composingSpanEnd);
    }
}
