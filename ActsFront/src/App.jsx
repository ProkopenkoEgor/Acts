import './App.css'
import LoginPage from './pages/LoginPage.jsx'
import AdminPage from './pages/AdminPage.jsx'
import HomePage from './pages/HomePage.jsx'
import { Routes, Route } from "react-router-dom"

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path="/login" element={ <LoginPage/> } />
        <Route path="/" element={ <LoginPage/> } />
        <Route path="/adminPage" element={ <AdminPage/> } />
        <Route path="/homePage" element={ <HomePage/> } />
      </Routes>
    </div>
  )
}

export default App
