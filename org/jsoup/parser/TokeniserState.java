package org.jsoup.parser;

import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import com.baidu.location.BDLocation;
import org.jsoup.parser.Token;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public enum TokeniserState {
    Data { // from class: org.jsoup.parser.TokeniserState.1
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.current()) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.emit(characterReader.consume());
                    return;
                case '&':
                    tokeniser.advanceTransition(CharacterReferenceInData);
                    return;
                case '<':
                    tokeniser.advanceTransition(TagOpen);
                    return;
                case 65535:
                    tokeniser.emit(new Token.EOF());
                    return;
                default:
                    tokeniser.emit(characterReader.consumeToAny('&', '<', TokeniserState.nullChar));
                    return;
            }
        }
    },
    CharacterReferenceInData { // from class: org.jsoup.parser.TokeniserState.2
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
            if (consumeCharacterReference == null) {
                tokeniser.emit('&');
            } else {
                tokeniser.emit(consumeCharacterReference);
            }
            tokeniser.transition(Data);
        }
    },
    Rcdata { // from class: org.jsoup.parser.TokeniserState.3
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.current()) {
                case 0:
                    tokeniser.error(this);
                    characterReader.advance();
                    tokeniser.emit(TokeniserState.replacementChar);
                    return;
                case '&':
                    tokeniser.advanceTransition(CharacterReferenceInRcdata);
                    return;
                case '<':
                    tokeniser.advanceTransition(RcdataLessthanSign);
                    return;
                case 65535:
                    tokeniser.emit(new Token.EOF());
                    return;
                default:
                    tokeniser.emit(characterReader.consumeToAny('&', '<', TokeniserState.nullChar));
                    return;
            }
        }
    },
    CharacterReferenceInRcdata { // from class: org.jsoup.parser.TokeniserState.4
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char[] consumeCharacterReference = tokeniser.consumeCharacterReference(null, false);
            if (consumeCharacterReference == null) {
                tokeniser.emit('&');
            } else {
                tokeniser.emit(consumeCharacterReference);
            }
            tokeniser.transition(Rcdata);
        }
    },
    Rawtext { // from class: org.jsoup.parser.TokeniserState.5
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.current()) {
                case 0:
                    tokeniser.error(this);
                    characterReader.advance();
                    tokeniser.emit(TokeniserState.replacementChar);
                    return;
                case '<':
                    tokeniser.advanceTransition(RawtextLessthanSign);
                    return;
                case 65535:
                    tokeniser.emit(new Token.EOF());
                    return;
                default:
                    tokeniser.emit(characterReader.consumeToAny('<', TokeniserState.nullChar));
                    return;
            }
        }
    },
    ScriptData { // from class: org.jsoup.parser.TokeniserState.6
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.current()) {
                case 0:
                    tokeniser.error(this);
                    characterReader.advance();
                    tokeniser.emit(TokeniserState.replacementChar);
                    return;
                case '<':
                    tokeniser.advanceTransition(ScriptDataLessthanSign);
                    return;
                case 65535:
                    tokeniser.emit(new Token.EOF());
                    return;
                default:
                    tokeniser.emit(characterReader.consumeToAny('<', TokeniserState.nullChar));
                    return;
            }
        }
    },
    PLAINTEXT { // from class: org.jsoup.parser.TokeniserState.7
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.current()) {
                case 0:
                    tokeniser.error(this);
                    characterReader.advance();
                    tokeniser.emit(TokeniserState.replacementChar);
                    return;
                case 65535:
                    tokeniser.emit(new Token.EOF());
                    return;
                default:
                    tokeniser.emit(characterReader.consumeTo(TokeniserState.nullChar));
                    return;
            }
        }
    },
    TagOpen { // from class: org.jsoup.parser.TokeniserState.8
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.current()) {
                case '!':
                    tokeniser.advanceTransition(MarkupDeclarationOpen);
                    return;
                case '/':
                    tokeniser.advanceTransition(EndTagOpen);
                    return;
                case BDLocation.TypeNetWorkException /* 63 */:
                    tokeniser.advanceTransition(BogusComment);
                    return;
                default:
                    if (characterReader.matchesLetter()) {
                        tokeniser.createTagPending(true);
                        tokeniser.transition(TagName);
                        return;
                    }
                    tokeniser.error(this);
                    tokeniser.emit('<');
                    tokeniser.transition(Data);
                    return;
            }
        }
    },
    EndTagOpen { // from class: org.jsoup.parser.TokeniserState.9
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.emit("</");
                tokeniser.transition(Data);
            } else if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.transition(TagName);
            } else if (characterReader.matches('>')) {
                tokeniser.error(this);
                tokeniser.advanceTransition(Data);
            } else {
                tokeniser.error(this);
                tokeniser.advanceTransition(BogusComment);
            }
        }
    },
    TagName { // from class: org.jsoup.parser.TokeniserState.10
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendTagName(characterReader.consumeToAny('\t', '\n', '\r', '\f', ' ', '/', '>', TokeniserState.nullChar).toLowerCase());
            switch (characterReader.consume()) {
                case 0:
                    tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BeforeAttributeName);
                    return;
                case '/':
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    return;
            }
        }
    },
    RcdataLessthanSign { // from class: org.jsoup.parser.TokeniserState.11
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(RCDATAEndTagOpen);
            } else if (characterReader.matchesLetter() && !characterReader.containsIgnoreCase("</" + tokeniser.appropriateEndTagName())) {
                tokeniser.tagPending = new Token.EndTag(tokeniser.appropriateEndTagName());
                tokeniser.emitTagPending();
                characterReader.unconsume();
                tokeniser.transition(Data);
            } else {
                tokeniser.emit("<");
                tokeniser.transition(Rcdata);
            }
        }
    },
    RCDATAEndTagOpen { // from class: org.jsoup.parser.TokeniserState.12
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(Character.toLowerCase(characterReader.current()));
                tokeniser.dataBuffer.append(Character.toLowerCase(characterReader.current()));
                tokeniser.advanceTransition(RCDATAEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(Rcdata);
        }
    },
    RCDATAEndTagName { // from class: org.jsoup.parser.TokeniserState.13
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                String consumeLetterSequence = characterReader.consumeLetterSequence();
                tokeniser.tagPending.appendTagName(consumeLetterSequence.toLowerCase());
                tokeniser.dataBuffer.append(consumeLetterSequence);
                return;
            }
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    if (tokeniser.isAppropriateEndTagToken()) {
                        tokeniser.transition(BeforeAttributeName);
                        return;
                    } else {
                        anythingElse(tokeniser, characterReader);
                        return;
                    }
                case '/':
                    if (tokeniser.isAppropriateEndTagToken()) {
                        tokeniser.transition(SelfClosingStartTag);
                        return;
                    } else {
                        anythingElse(tokeniser, characterReader);
                        return;
                    }
                case BDLocation.TypeCriteriaException /* 62 */:
                    if (tokeniser.isAppropriateEndTagToken()) {
                        tokeniser.emitTagPending();
                        tokeniser.transition(Data);
                        return;
                    }
                    anythingElse(tokeniser, characterReader);
                    return;
                default:
                    anythingElse(tokeniser, characterReader);
                    return;
            }
        }

        private void anythingElse(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit("</" + tokeniser.dataBuffer.toString());
            characterReader.unconsume();
            tokeniser.transition(Rcdata);
        }
    },
    RawtextLessthanSign { // from class: org.jsoup.parser.TokeniserState.14
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(RawtextEndTagOpen);
                return;
            }
            tokeniser.emit('<');
            tokeniser.transition(Rawtext);
        }
    },
    RawtextEndTagOpen { // from class: org.jsoup.parser.TokeniserState.15
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.transition(RawtextEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(Rawtext);
        }
    },
    RawtextEndTagName { // from class: org.jsoup.parser.TokeniserState.16
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, Rawtext);
        }
    },
    ScriptDataLessthanSign { // from class: org.jsoup.parser.TokeniserState.17
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '!':
                    tokeniser.emit("<!");
                    tokeniser.transition(ScriptDataEscapeStart);
                    return;
                case '/':
                    tokeniser.createTempBuffer();
                    tokeniser.transition(ScriptDataEndTagOpen);
                    return;
                default:
                    tokeniser.emit("<");
                    characterReader.unconsume();
                    tokeniser.transition(ScriptData);
                    return;
            }
        }
    },
    ScriptDataEndTagOpen { // from class: org.jsoup.parser.TokeniserState.18
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.transition(ScriptDataEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(ScriptData);
        }
    },
    ScriptDataEndTagName { // from class: org.jsoup.parser.TokeniserState.19
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptData);
        }
    },
    ScriptDataEscapeStart { // from class: org.jsoup.parser.TokeniserState.20
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('-')) {
                tokeniser.emit('-');
                tokeniser.advanceTransition(ScriptDataEscapeStartDash);
                return;
            }
            tokeniser.transition(ScriptData);
        }
    },
    ScriptDataEscapeStartDash { // from class: org.jsoup.parser.TokeniserState.21
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('-')) {
                tokeniser.emit('-');
                tokeniser.advanceTransition(ScriptDataEscapedDashDash);
                return;
            }
            tokeniser.transition(ScriptData);
        }
    },
    ScriptDataEscaped { // from class: org.jsoup.parser.TokeniserState.22
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            switch (characterReader.current()) {
                case 0:
                    tokeniser.error(this);
                    characterReader.advance();
                    tokeniser.emit(TokeniserState.replacementChar);
                    return;
                case '-':
                    tokeniser.emit('-');
                    tokeniser.advanceTransition(ScriptDataEscapedDash);
                    return;
                case '<':
                    tokeniser.advanceTransition(ScriptDataEscapedLessthanSign);
                    return;
                default:
                    tokeniser.emit(characterReader.consumeToAny('-', '<', TokeniserState.nullChar));
                    return;
            }
        }
    },
    ScriptDataEscapedDash { // from class: org.jsoup.parser.TokeniserState.23
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.emit(TokeniserState.replacementChar);
                    tokeniser.transition(ScriptDataEscaped);
                    return;
                case '-':
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataEscapedDashDash);
                    return;
                case '<':
                    tokeniser.transition(ScriptDataEscapedLessthanSign);
                    return;
                default:
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataEscaped);
                    return;
            }
        }
    },
    ScriptDataEscapedDashDash { // from class: org.jsoup.parser.TokeniserState.24
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.transition(Data);
                return;
            }
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.emit(TokeniserState.replacementChar);
                    tokeniser.transition(ScriptDataEscaped);
                    return;
                case '-':
                    tokeniser.emit(consume);
                    return;
                case '<':
                    tokeniser.transition(ScriptDataEscapedLessthanSign);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptData);
                    return;
                default:
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataEscaped);
                    return;
            }
        }
    },
    ScriptDataEscapedLessthanSign { // from class: org.jsoup.parser.TokeniserState.25
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTempBuffer();
                tokeniser.dataBuffer.append(Character.toLowerCase(characterReader.current()));
                tokeniser.emit("<" + characterReader.current());
                tokeniser.advanceTransition(ScriptDataDoubleEscapeStart);
            } else if (characterReader.matches('/')) {
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(ScriptDataEscapedEndTagOpen);
            } else {
                tokeniser.emit('<');
                tokeniser.transition(ScriptDataEscaped);
            }
        }
    },
    ScriptDataEscapedEndTagOpen { // from class: org.jsoup.parser.TokeniserState.26
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createTagPending(false);
                tokeniser.tagPending.appendTagName(Character.toLowerCase(characterReader.current()));
                tokeniser.dataBuffer.append(characterReader.current());
                tokeniser.advanceTransition(ScriptDataEscapedEndTagName);
                return;
            }
            tokeniser.emit("</");
            tokeniser.transition(ScriptDataEscaped);
        }
    },
    ScriptDataEscapedEndTagName { // from class: org.jsoup.parser.TokeniserState.27
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataEndTag(tokeniser, characterReader, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart { // from class: org.jsoup.parser.TokeniserState.28
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataDoubleEscaped, ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped { // from class: org.jsoup.parser.TokeniserState.29
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char current = characterReader.current();
            switch (current) {
                case 0:
                    tokeniser.error(this);
                    characterReader.advance();
                    tokeniser.emit(TokeniserState.replacementChar);
                    return;
                case '-':
                    tokeniser.emit(current);
                    tokeniser.advanceTransition(ScriptDataDoubleEscapedDash);
                    return;
                case '<':
                    tokeniser.emit(current);
                    tokeniser.advanceTransition(ScriptDataDoubleEscapedLessthanSign);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.emit(characterReader.consumeToAny('-', '<', TokeniserState.nullChar));
                    return;
            }
        }
    },
    ScriptDataDoubleEscapedDash { // from class: org.jsoup.parser.TokeniserState.30
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.emit(TokeniserState.replacementChar);
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;
                case '-':
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataDoubleEscapedDashDash);
                    return;
                case '<':
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;
            }
        }
    },
    ScriptDataDoubleEscapedDashDash { // from class: org.jsoup.parser.TokeniserState.31
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.emit(TokeniserState.replacementChar);
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;
                case '-':
                    tokeniser.emit(consume);
                    return;
                case '<':
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptData);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.emit(consume);
                    tokeniser.transition(ScriptDataDoubleEscaped);
                    return;
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign { // from class: org.jsoup.parser.TokeniserState.32
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matches('/')) {
                tokeniser.emit('/');
                tokeniser.createTempBuffer();
                tokeniser.advanceTransition(ScriptDataDoubleEscapeEnd);
                return;
            }
            tokeniser.transition(ScriptDataDoubleEscaped);
        }
    },
    ScriptDataDoubleEscapeEnd { // from class: org.jsoup.parser.TokeniserState.33
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            TokeniserState.handleDataDoubleEscapeTag(tokeniser, characterReader, ScriptDataEscaped, ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName { // from class: org.jsoup.parser.TokeniserState.34
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.tagPending.newAttribute();
                    characterReader.unconsume();
                    tokeniser.transition(AttributeName);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case '\"':
                case '\'':
                case '<':
                case BDLocation.TypeGpsLocation /* 61 */:
                    tokeniser.error(this);
                    tokeniser.tagPending.newAttribute();
                    tokeniser.tagPending.appendAttributeName(consume);
                    tokeniser.transition(AttributeName);
                    return;
                case '/':
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.tagPending.newAttribute();
                    characterReader.unconsume();
                    tokeniser.transition(AttributeName);
                    return;
            }
        }
    },
    AttributeName { // from class: org.jsoup.parser.TokeniserState.35
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.tagPending.appendAttributeName(characterReader.consumeToAny('\t', '\n', '\r', '\f', ' ', '/', '=', '>', TokeniserState.nullChar, '\"', '\'', '<').toLowerCase());
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName(TokeniserState.replacementChar);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(AfterAttributeName);
                    return;
                case '\"':
                case '\'':
                case '<':
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName(consume);
                    return;
                case '/':
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                case BDLocation.TypeGpsLocation /* 61 */:
                    tokeniser.transition(BeforeAttributeValue);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    return;
            }
        }
    },
    AfterAttributeName { // from class: org.jsoup.parser.TokeniserState.36
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeName(TokeniserState.replacementChar);
                    tokeniser.transition(AttributeName);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case '\"':
                case '\'':
                case '<':
                    tokeniser.error(this);
                    tokeniser.tagPending.newAttribute();
                    tokeniser.tagPending.appendAttributeName(consume);
                    tokeniser.transition(AttributeName);
                    return;
                case '/':
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                case BDLocation.TypeGpsLocation /* 61 */:
                    tokeniser.transition(BeforeAttributeValue);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.tagPending.newAttribute();
                    characterReader.unconsume();
                    tokeniser.transition(AttributeName);
                    return;
            }
        }
    },
    BeforeAttributeValue { // from class: org.jsoup.parser.TokeniserState.37
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                    tokeniser.transition(AttributeValue_unquoted);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case '\"':
                    tokeniser.transition(AttributeValue_doubleQuoted);
                    return;
                case '&':
                    characterReader.unconsume();
                    tokeniser.transition(AttributeValue_unquoted);
                    return;
                case '\'':
                    tokeniser.transition(AttributeValue_singleQuoted);
                    return;
                case '<':
                case BDLocation.TypeGpsLocation /* 61 */:
                case '`':
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(consume);
                    tokeniser.transition(AttributeValue_unquoted);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    characterReader.unconsume();
                    tokeniser.transition(AttributeValue_unquoted);
                    return;
            }
        }
    },
    AttributeValue_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.38
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAny = characterReader.consumeToAny('\"', '&', TokeniserState.nullChar);
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            }
            switch (characterReader.consume()) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                    return;
                case '\"':
                    tokeniser.transition(AfterAttributeValue_quoted);
                    return;
                case '&':
                    char[] consumeCharacterReference = tokeniser.consumeCharacterReference('\"', true);
                    if (consumeCharacterReference != null) {
                        tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                        return;
                    } else {
                        tokeniser.tagPending.appendAttributeValue('&');
                        return;
                    }
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    return;
            }
        }
    },
    AttributeValue_singleQuoted { // from class: org.jsoup.parser.TokeniserState.39
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAny = characterReader.consumeToAny('\'', '&', TokeniserState.nullChar);
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            }
            switch (characterReader.consume()) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                    return;
                case '&':
                    char[] consumeCharacterReference = tokeniser.consumeCharacterReference('\'', true);
                    if (consumeCharacterReference != null) {
                        tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                        return;
                    } else {
                        tokeniser.tagPending.appendAttributeValue('&');
                        return;
                    }
                case '\'':
                    tokeniser.transition(AfterAttributeValue_quoted);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    return;
            }
        }
    },
    AttributeValue_unquoted { // from class: org.jsoup.parser.TokeniserState.40
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            String consumeToAny = characterReader.consumeToAny('\t', '\n', '\r', '\f', ' ', '&', '>', TokeniserState.nullChar, '\"', '\'', '<', '=', '`');
            if (consumeToAny.length() > 0) {
                tokeniser.tagPending.appendAttributeValue(consumeToAny);
            }
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(TokeniserState.replacementChar);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BeforeAttributeName);
                    return;
                case '\"':
                case '\'':
                case '<':
                case BDLocation.TypeGpsLocation /* 61 */:
                case '`':
                    tokeniser.error(this);
                    tokeniser.tagPending.appendAttributeValue(consume);
                    return;
                case '&':
                    char[] consumeCharacterReference = tokeniser.consumeCharacterReference('>', true);
                    if (consumeCharacterReference != null) {
                        tokeniser.tagPending.appendAttributeValue(consumeCharacterReference);
                        return;
                    } else {
                        tokeniser.tagPending.appendAttributeValue('&');
                        return;
                    }
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    return;
            }
        }
    },
    AfterAttributeValue_quoted { // from class: org.jsoup.parser.TokeniserState.41
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BeforeAttributeName);
                    return;
                case '/':
                    tokeniser.transition(SelfClosingStartTag);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    characterReader.unconsume();
                    tokeniser.transition(BeforeAttributeName);
                    return;
            }
        }
    },
    SelfClosingStartTag { // from class: org.jsoup.parser.TokeniserState.42
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.tagPending.selfClosing = true;
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.transition(BeforeAttributeName);
                    return;
            }
        }
    },
    BogusComment { // from class: org.jsoup.parser.TokeniserState.43
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            characterReader.unconsume();
            Token.Comment comment = new Token.Comment();
            comment.bogus = true;
            comment.data.append(characterReader.consumeTo('>'));
            tokeniser.emit(comment);
            tokeniser.advanceTransition(Data);
        }
    },
    MarkupDeclarationOpen { // from class: org.jsoup.parser.TokeniserState.44
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchConsume("--")) {
                tokeniser.createCommentPending();
                tokeniser.transition(CommentStart);
            } else if (characterReader.matchConsumeIgnoreCase("DOCTYPE")) {
                tokeniser.transition(Doctype);
            } else if (characterReader.matchConsume("[CDATA[")) {
                tokeniser.transition(CdataSection);
            } else {
                tokeniser.error(this);
                tokeniser.advanceTransition(BogusComment);
            }
        }
    },
    CommentStart { // from class: org.jsoup.parser.TokeniserState.45
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append(TokeniserState.replacementChar);
                    tokeniser.transition(Comment);
                    return;
                case '-':
                    tokeniser.transition(CommentStartDash);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.commentPending.data.append(consume);
                    tokeniser.transition(Comment);
                    return;
            }
        }
    },
    CommentStartDash { // from class: org.jsoup.parser.TokeniserState.46
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append(TokeniserState.replacementChar);
                    tokeniser.transition(Comment);
                    return;
                case '-':
                    tokeniser.transition(CommentStartDash);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.commentPending.data.append(consume);
                    tokeniser.transition(Comment);
                    return;
            }
        }
    },
    Comment { // from class: org.jsoup.parser.TokeniserState.47
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.current()) {
                case 0:
                    tokeniser.error(this);
                    characterReader.advance();
                    tokeniser.commentPending.data.append(TokeniserState.replacementChar);
                    return;
                case '-':
                    tokeniser.advanceTransition(CommentEndDash);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.commentPending.data.append(characterReader.consumeToAny('-', TokeniserState.nullChar));
                    return;
            }
        }
    },
    CommentEndDash { // from class: org.jsoup.parser.TokeniserState.48
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append('-').append(TokeniserState.replacementChar);
                    tokeniser.transition(Comment);
                    return;
                case '-':
                    tokeniser.transition(CommentEnd);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.commentPending.data.append('-').append(consume);
                    tokeniser.transition(Comment);
                    return;
            }
        }
    },
    CommentEnd { // from class: org.jsoup.parser.TokeniserState.49
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append("--").append(TokeniserState.replacementChar);
                    tokeniser.transition(Comment);
                    return;
                case '!':
                    tokeniser.error(this);
                    tokeniser.transition(CommentEndBang);
                    return;
                case '-':
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append('-');
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append("--").append(consume);
                    tokeniser.transition(Comment);
                    return;
            }
        }
    },
    CommentEndBang { // from class: org.jsoup.parser.TokeniserState.50
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.commentPending.data.append("--!").append(TokeniserState.replacementChar);
                    tokeniser.transition(Comment);
                    return;
                case '-':
                    tokeniser.commentPending.data.append("--!");
                    tokeniser.transition(CommentEndDash);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.emitCommentPending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.commentPending.data.append("--!").append(consume);
                    tokeniser.transition(Comment);
                    return;
            }
        }
    },
    Doctype { // from class: org.jsoup.parser.TokeniserState.51
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BeforeDoctypeName);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.transition(BeforeDoctypeName);
                    return;
            }
        }
    },
    BeforeDoctypeName { // from class: org.jsoup.parser.TokeniserState.52
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.createDoctypePending();
                tokeniser.transition(DoctypeName);
                return;
            }
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.doctypePending.name.append(TokeniserState.replacementChar);
                    tokeniser.transition(DoctypeName);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.createDoctypePending();
                    tokeniser.doctypePending.name.append(consume);
                    tokeniser.transition(DoctypeName);
                    return;
            }
        }
    },
    DoctypeName { // from class: org.jsoup.parser.TokeniserState.53
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.matchesLetter()) {
                tokeniser.doctypePending.name.append(characterReader.consumeLetterSequence().toLowerCase());
                return;
            }
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.doctypePending.name.append(TokeniserState.replacementChar);
                    return;
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(AfterDoctypeName);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.doctypePending.name.append(consume);
                    return;
            }
        }
    },
    AfterDoctypeName { // from class: org.jsoup.parser.TokeniserState.54
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                tokeniser.eofError(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.emitDoctypePending();
                tokeniser.transition(Data);
            } else if (characterReader.matchesAny('\t', '\n', '\r', '\f', ' ')) {
                characterReader.advance();
            } else if (characterReader.matches('>')) {
                tokeniser.emitDoctypePending();
                tokeniser.advanceTransition(Data);
            } else if (characterReader.matchConsumeIgnoreCase("PUBLIC")) {
                tokeniser.transition(AfterDoctypePublicKeyword);
            } else if (characterReader.matchConsumeIgnoreCase("SYSTEM")) {
                tokeniser.transition(AfterDoctypeSystemKeyword);
            } else {
                tokeniser.error(this);
                tokeniser.doctypePending.forceQuirks = true;
                tokeniser.advanceTransition(BogusDoctype);
            }
        }
    },
    AfterDoctypePublicKeyword { // from class: org.jsoup.parser.TokeniserState.55
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BeforeDoctypePublicIdentifier);
                    return;
                case '\"':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    return;
            }
        }
    },
    BeforeDoctypePublicIdentifier { // from class: org.jsoup.parser.TokeniserState.56
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case '\"':
                    tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    return;
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.57
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.doctypePending.publicIdentifier.append(TokeniserState.replacementChar);
                    return;
                case '\"':
                    tokeniser.transition(AfterDoctypePublicIdentifier);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.doctypePending.publicIdentifier.append(consume);
                    return;
            }
        }
    },
    DoctypePublicIdentifier_singleQuoted { // from class: org.jsoup.parser.TokeniserState.58
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.doctypePending.publicIdentifier.append(TokeniserState.replacementChar);
                    return;
                case '\'':
                    tokeniser.transition(AfterDoctypePublicIdentifier);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.doctypePending.publicIdentifier.append(consume);
                    return;
            }
        }
    },
    AfterDoctypePublicIdentifier { // from class: org.jsoup.parser.TokeniserState.59
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BetweenDoctypePublicAndSystemIdentifiers);
                    return;
                case '\"':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    return;
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers { // from class: org.jsoup.parser.TokeniserState.60
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case '\"':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    return;
            }
        }
    },
    AfterDoctypeSystemKeyword { // from class: org.jsoup.parser.TokeniserState.61
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BeforeDoctypeSystemIdentifier);
                    return;
                case '\"':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.error(this);
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    return;
            }
        }
    },
    BeforeDoctypeSystemIdentifier { // from class: org.jsoup.parser.TokeniserState.62
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case '\"':
                    tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
                    return;
                case '\'':
                    tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.transition(BogusDoctype);
                    return;
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted { // from class: org.jsoup.parser.TokeniserState.63
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.doctypePending.systemIdentifier.append(TokeniserState.replacementChar);
                    return;
                case '\"':
                    tokeniser.transition(AfterDoctypeSystemIdentifier);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.doctypePending.systemIdentifier.append(consume);
                    return;
            }
        }
    },
    DoctypeSystemIdentifier_singleQuoted { // from class: org.jsoup.parser.TokeniserState.64
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            char consume = characterReader.consume();
            switch (consume) {
                case 0:
                    tokeniser.error(this);
                    tokeniser.doctypePending.systemIdentifier.append(TokeniserState.replacementChar);
                    return;
                case '\'':
                    tokeniser.transition(AfterDoctypeSystemIdentifier);
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.error(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.doctypePending.systemIdentifier.append(consume);
                    return;
            }
        }
    },
    AfterDoctypeSystemIdentifier { // from class: org.jsoup.parser.TokeniserState.65
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    return;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.eofError(this);
                    tokeniser.doctypePending.forceQuirks = true;
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    tokeniser.error(this);
                    tokeniser.transition(BogusDoctype);
                    return;
            }
        }
    },
    BogusDoctype { // from class: org.jsoup.parser.TokeniserState.66
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            switch (characterReader.consume()) {
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                case 65535:
                    tokeniser.emitDoctypePending();
                    tokeniser.transition(Data);
                    return;
                default:
                    return;
            }
        }
    },
    CdataSection { // from class: org.jsoup.parser.TokeniserState.67
        @Override // org.jsoup.parser.TokeniserState
        void read(Tokeniser tokeniser, CharacterReader characterReader) {
            tokeniser.emit(characterReader.consumeTo("]]>"));
            characterReader.matchConsume("]]>");
            tokeniser.transition(Data);
        }
    };
    
    private static final char eof = 65535;
    private static final char nullChar = 0;
    private static final char replacementChar = 65533;
    private static final String replacementStr = String.valueOf((char) replacementChar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void read(Tokeniser tokeniser, CharacterReader characterReader);

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDataEndTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.tagPending.appendTagName(consumeLetterSequence.toLowerCase());
            tokeniser.dataBuffer.append(consumeLetterSequence);
            return;
        }
        boolean z = false;
        if (tokeniser.isAppropriateEndTagToken() && !characterReader.isEmpty()) {
            char consume = characterReader.consume();
            switch (consume) {
                case '\t':
                case '\n':
                case '\f':
                case '\r':
                case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
                    tokeniser.transition(BeforeAttributeName);
                    break;
                case '/':
                    tokeniser.transition(SelfClosingStartTag);
                    break;
                case BDLocation.TypeCriteriaException /* 62 */:
                    tokeniser.emitTagPending();
                    tokeniser.transition(Data);
                    break;
                default:
                    tokeniser.dataBuffer.append(consume);
                    z = true;
                    break;
            }
        } else {
            z = true;
        }
        if (z) {
            tokeniser.emit("</" + tokeniser.dataBuffer.toString());
            tokeniser.transition(tokeniserState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleDataDoubleEscapeTag(Tokeniser tokeniser, CharacterReader characterReader, TokeniserState tokeniserState, TokeniserState tokeniserState2) {
        if (characterReader.matchesLetter()) {
            String consumeLetterSequence = characterReader.consumeLetterSequence();
            tokeniser.dataBuffer.append(consumeLetterSequence.toLowerCase());
            tokeniser.emit(consumeLetterSequence);
            return;
        }
        char consume = characterReader.consume();
        switch (consume) {
            case '\t':
            case '\n':
            case '\f':
            case '\r':
            case AccessibilityNodeInfoCompat.ACTION_LONG_CLICK /* 32 */:
            case '/':
            case BDLocation.TypeCriteriaException /* 62 */:
                if (tokeniser.dataBuffer.toString().equals("script")) {
                    tokeniser.transition(tokeniserState);
                } else {
                    tokeniser.transition(tokeniserState2);
                }
                tokeniser.emit(consume);
                return;
            default:
                characterReader.unconsume();
                tokeniser.transition(tokeniserState2);
                return;
        }
    }
}
